//틀림
package swea.d2.p2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionF {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] arr = new char[s.length()];
            System.out.println("#"+(i+1)+" "+fun(s));


        }


    }

    static int fun(String s) {

        boolean check = false;
        for (int i = 0; i < (s.length() / 2); i++) {
            int pl = 0;
            int pr = i+1;
            int count = 0;


            while (pl < i + 1) {
                if (s.charAt(pl) == s.charAt(pr)) {
                    pl++;
                    pr++;
                    count++;
                }else break;
            }
            if (count == pr) {
                return count;
            }
        }
        return -1;
    }




}
