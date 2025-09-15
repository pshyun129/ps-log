package swea.d2.p1989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            int result = fun(s);

            if (result == -1) {
                System.out.println("#"+(i+1)+" 0");
            }else System.out.println("#"+(i+1)+" 1");



        }

    }

    static int fun(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return -1;

            }
        }
        return 1;
    }
}
