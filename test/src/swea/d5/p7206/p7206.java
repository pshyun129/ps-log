package swea.d5.p7206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p7206 {
    static int max;


    static void dfs(String sum, int cnt) {
        if (Integer.parseInt(sum) < 10) {
            max = Math.max(max, cnt);

            return;
        }

        



        for (int i = 1; i < sum.length(); i++) {
            int a = Integer.parseInt(sum.substring(0, i));
            int b = Integer.parseInt(sum.substring(i));
            String s = (a*b) + "";
            dfs(s, cnt+1);


        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String S = br.readLine();
            max = Integer.MIN_VALUE;

            dfs(S, 0);

            System.out.printf("#%d %d\n", test_case, max);

        }


    }
}
