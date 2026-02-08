package swea.d3.p3499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3499 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int l, r;

            //홀수면 왼쪽 덱이 한장 더 많게
            if (N % 2 != 0) {
                l = N / 2 + 1;
                r = N / 2;
            } else {
                l = N/2;
                r = N/2;
            }

            Queue<String> left = new ArrayDeque<>();
            Queue<String> right = new ArrayDeque<>();

            for (int i = 0; i < l; i++) {
                left.offer(st.nextToken());
            }

            for (int i = 0; i < r; i++) {
                right.offer(st.nextToken());
            }

            //덱 셔플
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                if (i % 2 != 0) {
                    sb.append(left.poll()).append(" ");
                }else sb.append(right.poll()).append(" ");
            }
            System.out.printf("#%d %s\n", test_case, sb);
        }
    }
}
