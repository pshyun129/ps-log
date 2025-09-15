package swea.d2.p2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int ans = fun(s);

            if (ans == -1) {
                System.out.println("#" + (i + 1) + " error");
            } else {
                System.out.println("#" + (i + 1) + " "+ans);
            }





        }



    }
    static int fun(String s) {

        for (int i = 1; i <= (s.length() / 2); i++) {
            String a1 = s.substring(0, i);
            String a2 = s.substring(i + 1, 2 * i + 1);
            if (a1.equals(a2)) {
                return i+1;
            }

        }
        return -1;

    }
}
