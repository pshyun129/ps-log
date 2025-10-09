package swea.d3.p1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            String s = br.readLine();
            int count = 0;

            int check = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - '0' != check) {
                    count++;
                    //System.out.println(i+"번째 카운트" );
                    if (check == 0) {

                        check = 1;
                    } else if (check == 1) {
                        check = 0;
                    }

                    //System.out.println(check);
                }


            }
            System.out.println("#"+test_case+" "+count);



        }


    }
}
