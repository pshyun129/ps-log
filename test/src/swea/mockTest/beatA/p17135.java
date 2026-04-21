package swea.mockTest.beatA;
/*
그니까 궁수 3명을 어디에 배치해야 가장 최적일까 이걸 알아보자는 건데
dfs로 3명의 위치를 정해주고
정해졌을 때 시뮬레이션 돌려본 후
최댓값을 적는다

궁수는 범위 내에 가장 가까운 적을 쏜다
가까운 적이 여려명이라면 가장 왼쪽에 있는 적을 쏜다

같은 적이 여려 궁수한테 맞을 수 있다.

시뮬의 진행 방식은
궁수가 공격을 하고
적은 한칸 아래로 이동
모든 적이 격자판에서 사라진다면 게임은 종료

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p17135 {
    static int N, M, D;
    static int[][] arr;
    static int[] arrowsLocation;
    static int max;
    static int[][] arrCopyVer;

    // 배열 복사 메서드
    static void copyArr(int[][] a, int[][] b) {     // a값을 b에 복사
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                b[i][j] = a[i][j];
            }
        }
    }

    // 격자판 위에 적이 있는지 검사 -> true면 적이 남아있다
    static boolean check(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arrCopyVer[i][j] == 1) return true;
            }
        }

        return false;
    }

    // 병사들 한칸씩 앞으로 전진
    static void move(){
        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i > 0; i--) {
                arrCopyVer[i][j] = arrCopyVer[i-1][j];
            }
        }

        for (int i = 0; i < M; i++) {
            arrCopyVer[0][i] = 0;
        }

    }

    static int[] choiceTarget(int x, int y) {
        int tx = N+1;
        int ty = M+1;
        int distance = 100;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int a = (Math.abs(x - i) + Math.abs(y - j));
                if (a <= D && arrCopyVer[i][j] == 1) {
                    if (distance > a) {
                        distance = a;
                        tx = i;
                        ty = j;
                    } else if (distance == a) {
                        if (ty > j) {
                            tx = i;
                            ty = j;
                        }
                    }

                }


            }
        }
        return new int[]{tx, ty};
    }


    static int attak(){
        int kill = 0;
        int ax = N; // 궁수의 행 좌표
        List<int[]> targetList = new ArrayList<>();

        // 궁수별로 타겟을 설정
        for (int i = 0; i < 3; i++) {
            int ay = arrowsLocation[i]; // 궁수의 열 좌표

            targetList.add(choiceTarget(ax, ay));
        }

        // 공격

        for (int i = 0; i < targetList.size(); i++) {
            int[] a = targetList.get(i);
            if(a[0] == N+1 && a[1] == M+1)continue;

            System.out.println(a[0] + ", " + a[1]);

            if (arrCopyVer[a[0]][a[1]] == 1) {
                arrCopyVer[a[0]][a[1]] = 0;
                kill++;
            }

        }

        return kill;
    }

    static int simul(){
        int kill = 0;

        while (check()) {   // 격자판에 적군이 남아있다면

            // 궁수 공격
            kill += attak();

            // 적이 한칸 아래로 이동
            move();

        }

        return kill;
    }


    // 궁수 위치 선정
    static void dfs(int cnt, int idx) {
        if (cnt == 3) {
            copyArr(arr, arrCopyVer);

            // 현재 궁수 위치에서 시뮬레이션 돌려보고

            // 최댓값을 갱신 한 후 종료
            max = Math.max(max, simul());

            return;
        }

        for (int i = idx; i < M; i++) {
            arrowsLocation[cnt] = i;
            dfs(cnt + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        D = Integer.parseInt(st.nextToken());   // 궁수의 사거리

        arr = new int[N+1][M];  // 마지막 행은 궁수의 위치입니다.
        arrCopyVer = new int[N+1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrowsLocation = new int[3];


        max = 0;
        dfs(0, 0);
        System.out.print(max);
    }
}
