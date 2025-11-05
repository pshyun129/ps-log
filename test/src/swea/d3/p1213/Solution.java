package swea.d3.p1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static int search(String N, String sentense) {
        int result = 0;

        for (int i = 0; i <= sentense.length() - N.length(); i++) {
/*            int pl = 0;
            int pr = i;*/
            boolean check = true;
            for (int j = 0; j < N.length(); j++) {
                if (N.charAt(j) != sentense.charAt(i + j)) {
                    check = false;
                    break;
                } else if (N.charAt(j) == sentense.charAt(i + j)) {
                    continue;
                }
            }
            if (check == true) {
                result++;
            }



        }

        return result;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {

            String t = br.readLine();

            String N = br.readLine();

            String sentense = br.readLine();

            /*System.out.println(t);
            System.out.println(N);
            System.out.println(sentense);*/

            int result = search(N, sentense);

            System.out.println("#"+test_case+" "+result);



        }

    }
}
