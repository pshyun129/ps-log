package swea.d2.p1959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int findMax(int[] arr1, int[] arr2) {

        int max = 0;
        int pl = 0;
        int pr = 0;
        int sum =0;
        while (pl <= (arr2.length - arr1.length)) {
            if (pr < arr1.length) {
                sum += arr1[pr]*arr2[pl+pr];
                pr++;
            } else if (pr == arr1.length) {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
                pl++;
                pr = 0;
            }

        }
        return max;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;

            if (A.length < B.length) {
                result = findMax(A, B);

            } else if (A.length > B.length) {
                result = findMax(B, A);
            } else {
                for (int i = 0; i < A.length; i++) {
                    result+= A[i] * B[i];

                }
            }

            System.out.println("#"+test_case+" "+result);


        }


    }
}
