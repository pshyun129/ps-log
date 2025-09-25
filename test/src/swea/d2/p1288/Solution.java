package swea.d2.p1288;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine());

            boolean found = false;
            boolean[] check = new boolean[10];
            int a = 2;
            int k =  N;
            while (found == false) {



                String N2 = k + "";
                for (int i = 0; i < N2.length(); i++) {
                    if (check[N2.charAt(i)-'0'] == false) {
                        check[N2.charAt(i)-'0'] = true;
                    }
                }
                boolean check2 = true;
                for (int i = 0; i < 10; i++) {
                    if (check[i] == false) {
                        check2= false;
                    }
                }

                if (check2 == false) {
                    k = a*N;
                    a++;
                } else if (check2 == true) {
                    found = true;
                }
            }
            System.out.println("#"+test_case+" "+k);


        }

    }
}
