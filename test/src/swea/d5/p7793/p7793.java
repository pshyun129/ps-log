package swea.d5.p7793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7793 {
    static int N, M, fx, fy;
    static int[][] arr;     // 0:갈수있는 길, 1:수연이의 위치, 2:여신의 공간, 3:돌의 위치, 4:악마
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static boolean dead;
    static boolean can;
    static int min;

    static void dfs(int move, int x, int y) {

        if (arr[x][y] == 2) {
            can = true;
            min = Math.min(min, move);

            return;
        }


        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == -1 || arr[nx][ny] == 3 || arr[nx][ny] == 4) continue;

            int[][] backup = new int[N][M];

            copyArr(backup, arr);

            arr[x][y] = -1;
            arr[nx][ny] = 1;
            makeDav();
            if(dead){
                copyArr(arr, backup);
                continue;
            }

            dfs(move+1, nx, ny);

            copyArr(arr, backup);

        }



    }

    static void makeDav() {
        dead = false;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 4) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 2 || arr[nx][ny] == 3 || arr[nx][ny] == 4) continue;

                        if (arr[nx][ny] == 1) {
                            dead = true;
                        }
                        q.offer(nx);
                        q.offer(ny);
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            arr[x][y] = 4;
        }
    }


    static void copyArr(int[][] a, int[][] b) {     // a배열에 b를 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = b[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 행
            M = Integer.parseInt(st.nextToken());   // 열

            arr = new int[N][M];

            int x = 0;
            int y = 0;

            fx = 0;
            fy = 0;
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    char a = s.charAt(j);
                    switch (a) {
                        case 'D':
                            arr[i][j] = 2;
                            fx = i;
                            fy = j;
                            break;
                        case '*':
                            arr[i][j] = 4;
                            break;
                        case 'S':
                            arr[i][j] = 1;
                            x = i;
                            y = j;
                            break;
                        case 'X':
                            arr[i][j] = 3;
                            break;
                        case '.':
                            arr[i][j] = 0;
                            break;
                    }
                }
            }
            min = Integer.MAX_VALUE;
            can = false;

            dfs(0, x, y);

            if (!can) {
                System.out.printf("#%d GAME OVER", test_case);
            } else System.out.printf("#%d %d", test_case, min);


        }



    }
}
