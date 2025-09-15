package swea.d2.p1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String s = i+"";
            boolean check = false;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') {
                    System.out.print("-");
                    check = true;
                }
            }
            if (check == false) {
                System.out.print(s);
            }
            System.out.print(" ");


        }
    }
}
