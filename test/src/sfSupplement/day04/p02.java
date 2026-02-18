package sfSupplement.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;


public class p02 {
    static int N, M, Q;
    static int[][] arr;
    static int r1, c1, r2, c2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void wind(){
        int tmp1 = arr[r1][c1];

        for (int i = r1; i < r2; i++) {
            arr[i][c1] = arr[i + 1][c1];
        }

        for (int i = c1; i < c2; i++) {
            arr[r2][i] = arr[r2][i+1];
        }

        for (int i = r2; i > r1; i--) {
            arr[i][c2] = arr[i-1][c2];
        }

        for (int i = c2; i > c1+1; i--) {
            arr[r1][i] = arr[r1][i-1];
        }
        arr[r1][c1+1] = tmp1;


    }

    static void makeAvg(){
        int[][] arr2 = new int[r2 - r1 + 1][c2 - c1 + 1];

        for (int i = r1; i <= r2; i++) {

            for (int j = c1; j <= c2; j++) {
                int sum = arr[i][j];
                int count = 1;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }
                    sum += arr[nx][ny];
                    count++;
                }
                arr2[i-r1][j-c1] = sum / count;

            }
        }

        for (int i = r1; i <= r2; i++) {

            for (int j = c1; j <= c2; j++) {
                arr[i][j] = arr2[i - r1][j - c1];
            }
        }



    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken())-1;
            c1 = Integer.parseInt(st.nextToken())-1;
            r2 = Integer.parseInt(st.nextToken())-1;
            c2 = Integer.parseInt(st.nextToken())-1;
            wind();
            makeAvg();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);



    }
}
