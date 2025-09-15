package swea.d2.p2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //2차원 배열크기
            int M = Integer.parseInt(st.nextToken());   //구해야할 크기
            int[][] sum = new int[N+1][N+1];
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= N; k++) {
                    sum[j][k] = sum[j - 1][k] + sum[j][k - 1] - sum[j - 1][k - 1] + Integer.parseInt(st.nextToken());

                }
            }
            int max = 0;
            for (int j = 1; j <= N; j++) {
                int worn = j + M - 1;
                if (worn > N) {
                    break;
                }
                for (int k = 1; k <= N; k++) {
                    int worn2 = k + M - 1;
                    if (worn2 > N) {
                        break;
                    }
                    int result = sum[k + M - 1][j + M - 1] - sum[k - 1][j + M - 1] - sum[k + M - 1][j - 1] + sum[k - 1][j - 1];
                    if (result > max) {
                        max = result;
                    }


                }
            }
            System.out.println("#" + (i + 1) + " " + max);

        }

    }

}
