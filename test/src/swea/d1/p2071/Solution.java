package swea.d1.p2071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += Integer.parseInt(st.nextToken());
            }
            double ans = ((double) sum/(double) 10);
            long ans2 = Math.round(ans);
            System.out.println("#" + (i + 1) + " " + ans2);

        }
    }
}
