package swea.d2.p1986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int j = 1; j <= N; j++) {

                if (j % 2 == 0) {
                    sum -= j;
                }else sum +=j;

            }
            System.out.println("#"+(i+1)+" "+sum);


        }

    }
}
