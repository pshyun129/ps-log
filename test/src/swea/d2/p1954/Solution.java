package swea.d2.p1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static void makeArr(int[][] A, int N) {
        int direction = 0;
        int pl = 0;     //행
        int pr = 0;     //열

        for (int i = 1; i <= N * N; i++) {

            if (direction == 0) {
                A[pl][pr] = i;
                if (pr + 1 == N) {
                    direction++;
                    pl++;


                } else if (A[pl][pr+1] !=0) {
                    direction++;
                    pl++;
                } else {
                    pr++;
                }

            } else if (direction == 1) {
                A[pl][pr] = i;
                if (pl + 1 == N) {
                    direction++;
                    pr--;
                } else if (A[pl+1][pr] !=0) {
                    direction++;
                    pr--;
                } else {
                    pl++;
                }
            } else if (direction == 2) {
                A[pl][pr] = i;
                if ((pr - 1) == -1) {
                    direction++;
                    pl--;
                } else if (A[pl][pr-1] != 0) {
                    direction++;
                    pl--;
                } else {
                    pr--;
                }
            } else if (direction == 3) {
                A[pl][pr] = i;
                if (A[pl-1][pr] != 0) {
                    direction = 0;
                    pr++;
                } else {
                    pl--;
                }
            }
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine());
            int[][] A = new int[N][N];
            makeArr(A, N);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append("\n");
                for (int j = 0; j < N; j++) {
                    sb.append(A[i][j]).append(" ");
                }
            }

            System.out.println("#"+test_case+sb);

        }



    }
}
