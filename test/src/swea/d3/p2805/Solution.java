package swea.d3.p2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            int pl = N/2;
            int pr = N/2;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                String a = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[j] = a.charAt(j)-'0';

                }
                for (int j = pl; j <= pr; j++) {
                    sum += arr[j];

                }
                if (i >= N / 2) {
                    pl++;
                    pr--;
                } else {
                    pl--;
                    pr++;
                }


            }
            System.out.println("#"+test_case+" "+sum);




        }

    }


}
