package swea.d2.p1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionF {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());   //가로 세로 길이
            int K = Integer.parseInt(st.nextToken());   //단어 길이

            int[][] arr = new int[N+2][N+2];
            int[] check = new int[K + 2];
            for (int j = 1; j <= K; j++) {
                check[j] = 1;
            }

            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int j = 1; j <= N; j++) {
                int pl  = 0;
                int pr = 0;
                for (int e = 0; e < N+2-K-1; e++){
                    boolean check2 = true;
                    for (int f = 0; f < check.length; f++) {
                        if (arr[j][pr] != check[pr]) {
                            pl++;
                            pr = pl;
                            check2 = false;
                            break;
                        } else {
                            pr++;
                        }

                    }
                    if (check2 == true) {
                        result++;
                    }

                }
            }

            for (int j = 1; j <= N; j++) {
                int pl  = 0;
                int pr = 0;
                for (int e = 0; e <= N+2-K; e++){
                    boolean check3 = true;
                    for (int f = 0; f < check.length; f++) {
                        if (arr[pr][j] != check[pr]) {
                            pl++;
                            pr = pl;
                            check3 = false;
                            break;
                        } else {
                            pr++;
                        }

                    }
                    if (check3 == true) {
                        result++;
                    }

                }
            }

            System.out.println("#" + (i + 1) + " " + result);







        }

    }
}
