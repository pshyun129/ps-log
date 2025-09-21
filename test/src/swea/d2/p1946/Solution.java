package swea.d2.p1946;

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

            int check = 1;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String alphabet = st.nextToken();
                int count = Integer.parseInt(st.nextToken());
                for (int j = 1; j <= count; j++) {
                    sb.append(alphabet);
                    check++;
                    if (check > 10) {
                        sb.append("\n");
                        check =1;
                    }
                }

            }
            System.out.println("#"+test_case+"\n"+sb);



        }
    }
}
