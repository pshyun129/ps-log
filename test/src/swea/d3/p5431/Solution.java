package swea.d3.p5431;

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
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //수강생 수
            int K = Integer.parseInt(st.nextToken());   //과제를 제출한 사람의 수

            boolean[] arr = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= N; i++) {
                if (arr[i] == false) {
                    sb.append(i).append(" ");
                }
            }
            System.out.printf("#%d %s", test_case, sb);


        }


    }
}
