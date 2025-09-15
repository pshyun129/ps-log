package swea.d1.p2068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int j = 0; j < 10; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a > max) {
                    max = a;
                }

            }
            System.out.println("#"+(i+1)+" "+max);


        }





    }
}
