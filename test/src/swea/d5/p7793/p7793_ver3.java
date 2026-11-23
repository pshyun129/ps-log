package swea.d5.p7793;

/*
수연이의 위치 : S, 여신의 공간 : D, 돌의 위치 : X, 악마 : *
매턴 상하좌우로 수연이가 이동함, 악마도 상하 좌우로 퍼짐
악마는 돌과 여신의 공간으로는 못감
수연이는 돌은 못지나가고 여신의 공간으로 가야함
여신의 공간으로 갈 수 있는 최소 턴을 구해라
못가면 GAME OVER를 출력


bfs를 돌림, 턴제 느낌으로 한칸 이동하면 상하좌우 맵에 덮어쓰고 큐에 넣기 이런느낌일거 같은데
종료 조건이 그럼
수진이의 큐가 비면 끝임
수진이가 먼저 움직여야하고 악마는 그 다음턴에 움직임

여신의 공간에 도착했을때 -> 턴을 리턴해야하고
수진이의 큐가 비어서 끝나는 경우 게임 오버

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class p7793_ver3 {
    static int N;   // 세로
    static int M;   // 가로
    static char[][] map;    // 맵
    static ArrayDeque<int[]> sujinQueue;   // 수진의 위치
    static ArrayDeque<int[]> devilQueue;   // 악마의 위치
    static int[] goal;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0,  0, -1, 1};




    public static int simulation() {
        int turn = 0;      // 진행되는 턴 카운트
//        System.out.println("시뮬레이션 시작");

        while (!sujinQueue.isEmpty()) { // 수진이가 더 못움직이는 상황이 아니라면 계속 진행
            // 턴 시작
            turn++;

            // 수진이 이동
            int sujinCount = sujinQueue.size();
            for (int i = 0; i < sujinCount; i++) {
                int[] sujinLocation = sujinQueue.poll();    // 수진이의 위치

                // 악마한테 죽은 수진이라면 다음 수진이 ㄱㄱ
                if (map[sujinLocation[0]][sujinLocation[1]] == '*') continue;

                // 상하좌우 이동 후 수진 위치 기록, 큐에 넣기
                for (int d = 0; d < 4; d++) {
                    int nx = sujinLocation[0] + dx[d];
                    int ny = sujinLocation[1] + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    // 만약 이동할 다음 위치가 여신의 공간이라면
                    if (map[nx][ny] == 'D') {
                        return turn;
                    } else if (map[nx][ny] == '*' || map[nx][ny] == 'X' || map[nx][ny] == 'S') { // 만약 이동할 다음 위치가 이동 불가 지역이라면(돌, 악마, 수연)
                        continue;
                    } else {    // 아니면 맵에 수진이 표시 후 큐에 넣기
                        map[nx][ny] = 'S';
                        sujinQueue.offer(new int[] {nx, ny});
//                        System.out.println("큐에 넣음");
                    }
                }
            }


            // 악마 이동
            int devilCount = devilQueue.size();
            for (int i = 0; i < devilCount; i++) {
                int[] devilLocation = devilQueue.poll();


                for (int d = 0; d < 4; d++) {
                    int nx = devilLocation[0] + dx[d];
                    int ny = devilLocation[1] + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                    // 만약 이동할 다음 위치가 이동 불가 위치라면
                    if (map[nx][ny] == '*' || map[nx][ny] == 'X' || map[nx][ny] == 'D') {
                        continue;
                    }  else {    // 아니면 맵에 수진이 표시 후 큐에 넣기
                        map[nx][ny] = '*';
                        devilQueue.offer(new int[] {nx, ny});
                    }
                }


            }



        }


        return -1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map =  new char[N][M];  // 세로가 N, 가로가 M

            sujinQueue = new ArrayDeque<>();
            devilQueue = new ArrayDeque<>();

            // 맵 채우기
            for (int i = 0; i < N; i++) {
                String a = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = a.charAt(j);
                    if(map[i][j] == 'S'){
                        sujinQueue.offer(new int[]{i, j});  // 수진이의 위치면 큐에 담음
                    }else if (map[i][j] == '*') {
                        devilQueue.offer(new int[]{i, j});  // 악마의 위치면 악마 큐에 담음
                    } else if (map[i][j] == 'D') {
                        goal = new int[]{i, j};     // 여신의 방 위치면 여신의 방에 등록

                    }
                }
            }

            int result = simulation();

            if(result == -1){
                sb.append("#").append(test_case).append(" GAME OVER").append("\n");
            }else {
                sb.append("#").append(test_case).append(" ").append(result).append("\n");
            }
//            System.out.println(test_case + "번째 종료");


        }

        System.out.print(sb);


    }



}
