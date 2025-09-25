package swea.d2.p1204;

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
            st = new StringTokenizer(br.readLine());
            int[] check = new int[101];

            for (int i = 1; i <= 1000; i++) {
                check[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0;
            int idx = 0;
            for (int i = 0; i < 101; i++) {

                if (check[i] >= max) {
                    max = check[i];
                    idx = i;
                }

            }
            System.out.println("#"+test_case+" "+idx);





        }
    }
}
