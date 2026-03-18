package swea.d5.p7793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7793_2 {
    static int N, M;
    static char[][] arr;        // S : 수연이의 위치, D : 여신의 공간, X : 돌의 위치, * : 악마, . : 평범한 지역
    static Queue<int[]> sy, dev;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static int bfs(){
        int turn = 0;
        boolean move;

        while (!sy.isEmpty()) {

            // 악마 확산
            int devSize = dev.size();

            for (int i = 0; i < devSize; i++) {

                int[] dp = dev.poll();


                for (int d = 0; d < 4; d++) {
                    int nx = dp[0] + dx[d];
                    int ny = dp[1] + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 'X' || arr[nx][ny] == '*' || arr[nx][ny] == 'D') continue;
                    arr[nx][ny] = '*';
                    dev.offer(new int[]{nx, ny});
                }
            }



            move = false;
            // 수연의 이동
            int sySize = sy.size();
            for (int i = 0; i < sySize; i++) {
                int[] sp = sy.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = sp[0] + dx[d];
                    int ny = sp[1] + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 'X' || arr[nx][ny] == '*' || arr[nx][ny] == 'S') continue;
                    if(arr[nx][ny] == 'D') return turn+1;
                    arr[nx][ny] = 'S';
                    move = true;
                    sy.offer(new int[]{nx, ny});

                }



            }

            if(move) turn++;



        }


        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new char[N][M];

            sy = new ArrayDeque<>();
            dev = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = s.charAt(j);
                    if (arr[i][j] == 'S') {
                        sy.offer(new int[]{i, j});
                    }
                    if (arr[i][j] == '*') {
                        dev.offer(new int[]{i, j});
                    }
                }
            }

            int result = bfs();

            if (result == -1) {
                sb.append("#").append(test_case).append(" ").append("GAME OVER").append("\n");
            }else sb.append("#").append(test_case).append(" ").append(result).append("\n");



        }
        System.out.print(sb);



    }

}
