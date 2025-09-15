package swea.d1.p2058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int sum =0;
        for (int i = 0; i < S.length(); i++) {
            sum += S.charAt(i) - '0';


        }
        System.out.print(sum);

    }
}
