package swea.d2.p1970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());

            if ((N / 50000) > 0) {
                sb.append(N / 50000).append(" ");
                N = N % 50000;
            } else {
                sb.append(0).append(" ");
                N = N % 50000;
            }

            if ((N / 10000) > 0) {
                sb.append(N / 10000).append(" ");
                N = N % 10000;
            } else {
                sb.append(0).append(" ");
                N = N % 10000;
            }

            if ((N / 5000) > 0) {
                sb.append(N / 5000).append(" ");
                N = N % 5000;
            } else {
                sb.append(0).append(" ");
                N = N % 5000;
            }

            if ((N / 1000) > 0) {
                sb.append(N / 1000).append(" ");
                N = N % 1000;
            } else {
                sb.append(0).append(" ");
                N = N % 1000;
            }

            if ((N / 500) > 0) {
                sb.append(N / 500).append(" ");
                N = N % 500;
            } else {
                sb.append(0).append(" ");
                N = N % 500;
            }

            if ((N / 100) > 0) {
                sb.append(N / 100).append(" ");
                N = N % 100;
            } else {
                sb.append(0).append(" ");
                N = N % 100;
            }

            if ((N / 50) > 0) {
                sb.append(N / 50).append(" ");
                N = N % 50;
            } else {
                sb.append(0).append(" ");
                N = N % 50;
            }

            if ((N / 10) > 0) {
                sb.append(N / 10).append(" ");
                N = N % 10;
            } else {
                sb.append(0).append(" ");
                N = N % 10;
            }

            System.out.println("#" + test_case);
            System.out.println(sb);




        }

    }
}
