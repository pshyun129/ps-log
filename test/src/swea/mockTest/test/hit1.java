package swea.mockTest.test;

import java.net.*;
import java.io.*;

public class hit1 {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "DAEJEON02_JAVA";

    // 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
    static final String HOST = "127.0.0.1";

    // 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경에 대한 상수입니다.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    static final int[][] HOLES = {
            {0, 0}, {127, 0}, {254, 0},
            {0, 127}, {127, 127}, {254, 127}
    };

    // ====== Bot tuning constants ======
    // 공 중심-중심 충돌 거리(= 지름)로 사용하는 값 (일타싸피 포켓봇들에서 흔히 5.73 사용)
    static final float BALL_DIAM = 5.73f;

    // "경로에 공이 있는지" 판정 여유 (1.0에 가까울수록 더 보수적)
    static final float BLOCK_EPS = 0.95f;

    static final float MIN_POWER = 12f;
    static final float MAX_POWER = 100f;

    static class ShotDecision {
        float angle;
        float power;
        int targetIdx;     // 이번에 치려는 목적구 index
        int holeIdx;       // 노리는 포켓 index (0~5), -1이면 포켓 미고려 fallback
        float aimX, aimY;  // 조준점(고스트볼 지점)
        boolean usesAim;   // true면 aim으로 조준, false면 목적구 중심 조준
    }

    public static void main(String[] args) {

        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int) balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;

                //////////////////////////////
                // 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
                //////////////////////////////

                // ====== 여기서부터 플레이 로직 ======

                // (1) 샷 결정(atan2 + 포켓조준(고스트볼) + 장애물 + "5번은 내 공 다 넣은 뒤만" + 첫 충돌 엄격 체크)
                ShotDecision sd = decideShot(balls, order);

                // (2) 서버로 보낼 최종 angle/power
                angle = sd.angle;
                power = sd.power;

                // 디버그가 필요하면 아래 출력 사용
                System.out.println("[SHOT] target=" + sd.targetIdx
                        + " hole=" + sd.holeIdx
                        + " usesAim=" + sd.usesAim
                        + " aim=(" + sd.aimX + "," + sd.aimY + ")"
                        + " angle=" + angle + " power=" + power);

                //////////////////////////////
                // 이 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
                //////////////////////////////

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // ====== Bot Helpers ======
    // =========================

    static ShotDecision decideShot(float[][] balls, int order) {
        float cueX = balls[0][0], cueY = balls[0][1];

        // 1) "합법 후보"만 구성:
        //    - 내 공(선공: 1,3 / 후공: 2,4)이 남아있으면 내 공만 후보
        //    - 내 공이 모두 들어갔으면 그때만 5번 후보
        int[] my = (order == 1) ? new int[]{1, 3} : new int[]{2, 4};

        int[] targets = new int[2];     // 타겟 배열
        int tCnt = 0;                   // 아래를 진행하면 타겟의 갯수가 됨
        for (int idx : my) {
            if (isAlive(balls, idx)) targets[tCnt++] = idx;     // 내가 쳐야하는 공이 살아있다면 타겟배열에 넣는다
        }
        boolean canHitLast = (tCnt == 0); // 내 공이 하나도 없을 때만
        int lastTarget = (canHitLast && isAlive(balls, 5)) ? 5 : -1;

        ShotDecision best = null;
        double bestScore = Double.POSITIVE_INFINITY;

        // 2) (내 공이 남아있으면) 내 공 후보들을 평가
        for (int i = 0; i < tCnt; i++) {
            int tIdx = targets[i];
            ShotDecision cand = evaluateTargetAllHoles(balls, cueX, cueY, tIdx);
            if (cand != null) {
                double score = scoreOf(cand, balls, cueX, cueY);
                if (score < bestScore) {
                    bestScore = score;
                    best = cand;
                }
            }
        }

        // 3) (내 공이 없을 때만) 5번을 평가
        if (best == null && lastTarget != -1) {
            ShotDecision cand = evaluateTargetAllHoles(balls, cueX, cueY, lastTarget);
            if (cand != null) {
                best = cand;
            }
        }

        // 4) 포켓 조준 샷이 하나도 안 나오면: 합법 타겟으로 "그냥 맞추기" fallback
        if (best == null) {
            int fallbackTarget = firstAliveMyBall(balls, order);
            if (fallbackTarget == -1 && canHitLast && isAlive(balls, 5)) fallbackTarget = 5;

            ShotDecision sd = new ShotDecision();
            sd.targetIdx = fallbackTarget;
            sd.holeIdx = -1;
            sd.usesAim = false;
            sd.aimX = -1; sd.aimY = -1;

            if (fallbackTarget != -1) {
                float objX = balls[fallbackTarget][0], objY = balls[fallbackTarget][1];
                sd.angle = toGameAngle(cueX, cueY, objX, objY);

                double d = dist(cueX, cueY, objX, objY);
                sd.power = clamp((float) (14 + 0.28 * d), MIN_POWER, MAX_POWER);
            } else {
                // 이상 상황: 칠 공이 없다
                sd.angle = 0f;
                sd.power = 20f;
            }
            best = sd;
        }

        return best;
    }

    static ShotDecision evaluateTargetAllHoles(float[][] balls, float cueX, float cueY, int tIdx) {
        if (!isAlive(balls, tIdx)) return null;

        float objX = balls[tIdx][0], objY = balls[tIdx][1];

        ShotDecision best = null;
        double bestScore = Double.POSITIVE_INFINITY;

        for (int h = 0; h < HOLES.length; h++) {
            float holeX = HOLES[h][0], holeY = HOLES[h][1];

            // 목적구 -> 포켓 벡터
            float vx = holeX - objX;
            float vy = holeY - objY;
            float vlen = (float) Math.sqrt(vx * vx + vy * vy);
            if (vlen < 1e-6) continue;

            float ux = vx / vlen;
            float uy = vy / vlen;

            // 고스트볼 조준점: aim = obj - BALL_DIAM * unit(obj->hole)
            float aimX = objX - BALL_DIAM * ux;
            float aimY = objY - BALL_DIAM * uy;

            // 조준점이 테이블 밖이면 제외(간단 필터)
            if (!inTable(aimX, aimY)) continue;

            // ====== 엄격 조건 1) "첫 충돌은 반드시 목표공" ======
            // 수구가 aim까지 가는 동안 다른 공이 먼저 맞을 수 있으면 탈락
            if (!firstCollisionIsTarget(balls, cueX, cueY, aimX, aimY, tIdx)) continue;

            // ====== 조건 2) 목적구->포켓 경로에 다른 공이 막지 않아야 ======
            if (!isSegmentClear(balls, objX, objY, holeX, holeY, 0, tIdx)) continue;

            // 컷각(직선성) 평가: dot이 낮을수록 얇은 컷(난이도↑)
            float u1x = aimX - cueX, u1y = aimY - cueY;
            float u1len = (float) Math.sqrt(u1x * u1x + u1y * u1y);
            if (u1len < 1e-6) continue;
            u1x /= u1len;
            u1y /= u1len;

            float dot = u1x * ux + u1y * uy; // 1에 가까울수록 쉬운 샷
            if (dot < 0.15f) continue;       // 너무 얇은 컷은 안정상 제외

            double distCueAim = u1len;
            double distObjHole = vlen;

            // 스코어(낮을수록 좋음): 거리 + 컷 페널티
            double cutPenalty = 1.0 / Math.max(0.25, dot);
            double score = distCueAim + 0.85 * distObjHole + 25.0 * (cutPenalty - 1.0);

            if (score < bestScore) {
                ShotDecision sd = new ShotDecision();
                sd.targetIdx = tIdx;
                sd.holeIdx = h;
                sd.aimX = aimX;
                sd.aimY = aimY;
                sd.usesAim = true;

                sd.angle = toGameAngle(cueX, cueY, aimX, aimY);
                sd.power = computePower(distCueAim, distObjHole, dot);

                bestScore = score;
                best = sd;
            }
        }

        return best;
    }

    // 이 cand가 얼마나 좋은지(비교용) — evaluate 내부 score랑 동일한 계열로 유지
    static double scoreOf(ShotDecision sd, float[][] balls, float cueX, float cueY) {
        if (sd == null || !sd.usesAim || sd.holeIdx < 0) return Double.POSITIVE_INFINITY;

        float objX = balls[sd.targetIdx][0], objY = balls[sd.targetIdx][1];
        float holeX = HOLES[sd.holeIdx][0], holeY = HOLES[sd.holeIdx][1];

        double d1 = dist(cueX, cueY, sd.aimX, sd.aimY);
        double d2 = dist(objX, objY, holeX, holeY);

        // dot 재계산(대략 비교용)
        float ux = holeX - objX, uy = holeY - objY;
        float vlen = (float)Math.sqrt(ux*ux + uy*uy);
        if (vlen < 1e-6) return Double.POSITIVE_INFINITY;
        ux /= vlen; uy /= vlen;

        float u1x = sd.aimX - cueX, u1y = sd.aimY - cueY;
        float u1len = (float)Math.sqrt(u1x*u1x + u1y*u1y);
        if (u1len < 1e-6) return Double.POSITIVE_INFINITY;
        u1x /= u1len; u1y /= u1len;

        float dot = u1x*ux + u1y*uy;
        double cutPenalty = 1.0 / Math.max(0.25, dot);

        return d1 + 0.85*d2 + 25.0*(cutPenalty - 1.0);
    }

    // ====== "첫 충돌은 목표공" 엄격 체크 ======
    // 수구 중심이 (cue)->(aim)로 직선 이동한다고 가정할 때,
    // 목표공(tIdx)을 제외한 어떤 공도 aim까지 가는 구간에서 충돌 가능하면 false.
    static boolean firstCollisionIsTarget(float[][] balls, float cueX, float cueY, float aimX, float aimY, int tIdx) {
        float dirX = aimX - cueX;
        float dirY = aimY - cueY;
        float len = (float)Math.sqrt(dirX*dirX + dirY*dirY);
        if (len < 1e-6f) return false;

        // 단위 방향벡터
        float ux = dirX / len;
        float uy = dirY / len;

        float collideDist = BALL_DIAM * BLOCK_EPS;

        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            if (i == 0 || i == tIdx) continue;      // 수구(0)와 목표공은 제외
            if (!isAlive(balls, i)) continue;

            float px = balls[i][0], py = balls[i][1];

            // cue->ball 벡터
            float apx = px - cueX;
            float apy = py - cueY;

            // 진행방향으로의 투영 길이 t
            float t = apx*ux + apy*uy;
            if (t <= 0f) continue;
            if (t >= len) continue; // aim 이후는 무시 (aim까지 도달하기 전 충돌만 체크)

            // 수직거리 d
            float cx = cueX + t*ux;
            float cy = cueY + t*uy;
            float dx = px - cx;
            float dy = py - cy;
            float d = (float)Math.sqrt(dx*dx + dy*dy);

            // 수구 중심선이 이 공 중심에 collideDist 이내로 접근하면,
            // aim 도달 전에 이 공을 먼저 칠 위험이 크다고 보고 탈락
            if (d <= collideDist) return false;
        }

        // 추가로 "선분 자체"가 비정상적으로 포켓/벽을 뚫는 건 이 게임에선 보통 엔진이 막지만,
        // 여기서는 단순히 다른 공과의 선충돌만 엄격 체크한다.
        return true;
    }

    // 목적구->포켓 같은 "선분 경로에 다른 공이 가까이 있으면" 막혔다고 보는 체크
    static boolean isSegmentClear(float[][] balls, float ax, float ay, float bx, float by, int ignoreA, int ignoreB) {
        float blockDist = BALL_DIAM * BLOCK_EPS;
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            if (i == ignoreA || i == ignoreB) continue;
            if (!isAlive(balls, i)) continue;

            float px = balls[i][0], py = balls[i][1];
            float d = distPointToSegment(px, py, ax, ay, bx, by);
            if (d <= blockDist) return false;
        }
        return true;
    }

    static float distPointToSegment(float px, float py, float ax, float ay, float bx, float by) {
        float abx = bx - ax, aby = by - ay;
        float apx = px - ax, apy = py - ay;

        float ab2 = abx*abx + aby*aby;
        if (ab2 < 1e-6f) return (float)Math.sqrt(apx*apx + apy*apy);

        float t = (apx*abx + apy*aby) / ab2;
        if (t < 0f) t = 0f;
        else if (t > 1f) t = 1f;

        float cx = ax + t * abx;
        float cy = ay + t * aby;
        float dx = px - cx, dy = py - cy;
        return (float)Math.sqrt(dx*dx + dy*dy);
    }

    // atan2 기반 각도 변환:
    // 표준각(deg): 0=+x(오른쪽), CCW 증가
    // 게임각(game): 0=+y(아래), CW 증가
    static float toGameAngle(float fromX, float fromY, float toX, float toY) {
        double dx = toX - fromX;
        double dy = toY - fromY;

        double deg = Math.toDegrees(Math.atan2(dy, dx)); // -180..180, 0=+x
        double game = (90.0 - deg + 360.0) % 360.0;      // 0=+y(아래), 90=+x
        return (float) game;
    }

    static float computePower(double distCueAim, double distObjHole, double dot) {
        // 거리 기반 기본 힘
        double base = 18.0 + 0.23 * distCueAim + 0.18 * distObjHole;

        // 컷이 얇을수록(dot 작을수록) 보정
        double cutBoost = 1.0 / Math.sqrt(Math.max(0.30, dot));

        double p = base * cutBoost;
        return clamp((float) p, MIN_POWER, MAX_POWER);
    }

    static boolean inTable(float x, float y) {
        return x >= 0f && x <= TABLE_WIDTH && y >= 0f && y <= TABLE_HEIGHT;
    }

    static boolean isAlive(float[][] balls, int idx) {
        return balls[idx][0] != -1f && balls[idx][1] != -1f;
    }

    static int firstAliveMyBall(float[][] balls, int order) {
        if (order == 1) {
            if (isAlive(balls, 1)) return 1;
            if (isAlive(balls, 3)) return 3;
        } else {
            if (isAlive(balls, 2)) return 2;
            if (isAlive(balls, 4)) return 4;
        }
        return -1;
    }

    static float clamp(float v, float lo, float hi) {
        return Math.max(lo, Math.min(hi, v));
    }

    static double dist(float x1, float y1, float x2, float y2) {
        double dx = x2 - x1, dy = y2 - y1;
        return Math.sqrt(dx*dx + dy*dy);
    }
}