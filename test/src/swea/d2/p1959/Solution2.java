package swea.d2.p1959;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    static int[] A;
    static int[] B;
    static int N;
    static int M;

    static int search(int x, int y, boolean z) {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i <= x - y; i++) {
            int sum = 0;
            for (int j = 0; j < y; j++) {
                if (z) {
                    sum += A[j] * B[i + j];
                } else {
                    sum += B[j] * A[i + j];
                }
            }
            if (sum > answer) {
                answer = sum;
            }

        }
        return  answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //a배열길이
            M = Integer.parseInt(st.nextToken());   //b배열길이

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            int answer = Integer.MIN_VALUE;
            if (M > N) {
                answer = search(M, N, true);
            } else {
                answer = search(N, M, false);
            }

            System.out.println("#"+test_case+" "+answer);

        }
    }
}
