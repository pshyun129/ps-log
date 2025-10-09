package swea.d3.p1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {

            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];


            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                }
            }

            int max = 0;

            for (int i = 0; i < 100; i++) {

                int sum1 = 0;
                int sum2 = 0;
                for (int j = 0; j < 100; j++) {
                    sum1+=arr[i][j];
                    sum2+=arr[j][i];
                }
                if (sum1 > max) {
                    max = sum1;
                }
                if (sum2 > max) {
                    max = sum2;
                }
            }

            int a = 0;
            int b = 99;

            int sum3 = 0;
            int sum4 = 0;
            for (int i = 0; i < 100; i++) {

                sum3+=arr[a][b];
                sum4+= arr[a][a];
                a++;
                b--;

            }
            if (max < sum3) {
                max = sum3;
            }
            if (max < sum4) {
                max = sum4;
            }

            System.out.println("#"+test_case+" "+max);


        }


    }
}
