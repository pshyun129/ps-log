package sfSupplement.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p01 {

    static int N, M, T;
    static int[][] grid;
    static int[][] marbles;
    static int[][] check;
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};


    static void moveMarbles() {
        for (int i = 0; i < M; i++) {
            if(marbles[i][0] == -1 && marbles[i][1] == -1) continue;
            int row = marbles[i][0];    // 행
            int col = marbles[i][1];    // 열
            int max = 0;
            int direc = 0;
            for (int d = 0; d < 4; d++) {
                int nx = row + dx[d];
                int ny = col + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                if (max < grid[nx][ny]) {
                    max = grid[nx][ny];
                    direc = d;

                }
            }
            check[row][col]--;

            marbles[i][0] = row + dx[direc];
            marbles[i][1] = col + dy[direc];

            check[marbles[i][0]][marbles[i][1]]++;

        }
    }

    static void checkDie() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check[i][j] > 1) {
                    check[i][j] = 0;
                    for (int k = 0; k < M; k++) {
                        if (marbles[k][0] == i && marbles[k][1] == j) {
                            marbles[k][0] = -1;
                            marbles[k][1] = -1;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        check = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        marbles = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            marbles[i][0] = Integer.parseInt(st.nextToken()) - 1;
            marbles[i][1] = Integer.parseInt(st.nextToken()) - 1;
            check[marbles[i][0]][marbles[i][1]]++;

        }

        for (int i = 0; i < T; i++) {

            moveMarbles();
            checkDie();
        }

        int count = 0;
        for (int i = 0; i < M; i++) {
            if(marbles[i][0] == -1) continue;
            count++;
        }
        System.out.print(count);





    }
}
