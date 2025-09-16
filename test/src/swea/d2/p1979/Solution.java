package swea.d2.p1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());   //가로 세로 길이
            int K = Integer.parseInt(st.nextToken());   //단어 길이

            int[][] arr = new int[N][N];


            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == 1) {
                        count++;

                    } else {
                        if (count == K) {
                            result++;
                        }
                        count =0;
                    }
                }
                if (count == K) {
                    result++;
                }
            }

            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int k = 0; k < N; k++) {
                    if (arr[k][j] == 1) {
                        count++;

                    } else {
                        if (count == K) {
                            result++;
                        }
                        count =0;
                    }
                }
                if (count == K) {
                    result++;
                }

            }




            System.out.println("#" + (i + 1) + " " + result);







        }

    }



}
