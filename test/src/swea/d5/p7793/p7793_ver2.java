package swea.d5.p7793;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7793_ver2 {
    static int N, M;
    static int[][] arr;     // 0 : 이동 가능 구역(.), 1 : 수연이의 위치(S), 2 : 여신의 공간(D), 3 : 돌의 위치(X) 4 : 악마(*)
    static Queue<int[]> sq, dq;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs() {
        int time = 0;

        while (!sq.isEmpty()) {
            time++;

            // 악마
            int dsize = dq.size();
            for (int i = 0; i < dsize; i++) {
                int[] dev = dq.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = dev[0] + dx[d];
                    int ny = dev[1] + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 2 || arr[nx][ny] == 3|| arr[nx][ny] == 4) continue;
                    arr[nx][ny] = 4;
                    dq.offer(new int[]{nx, ny});


                }


            }

            // 수연 이동
            int sSize = sq.size();
            for (int i = 0; i < sSize; i++) {
                int[] su = sq.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = su[0] + dx[d];
                    int ny = su[1] + dy[d];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] == 1 || arr[nx][ny] == 3|| arr[nx][ny] == 4) continue;
                    if(arr[nx][ny] == 2) return time;
                    arr[nx][ny] = 1;
                    sq.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
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

            sq = new ArrayDeque<>();
            dq = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    char a = s.charAt(j);

                    switch (a) {
                        case '.':
                            arr[i][j] = 0;
                            break;
                        case 'S':
                            arr[i][j] = 1;
                            sq.offer(new int[]{i, j});
                            break;
                        case 'D':
                            arr[i][j] = 2;
                            break;
                        case 'X':
                            arr[i][j] = 3;
                            break;
                        case '*':
                            arr[i][j] = 4;
                            dq.offer(new int[]{i, j});
                            break;
                    }


                }
            }

            int result = bfs();

            if (result == -1) {
                System.out.printf("#%d GAME OVER \n", test_case);
            } else System.out.printf("#%d %d\n", test_case, result);




        }


    }

}
