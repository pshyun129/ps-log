package swea.d2.p1284;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int Acompany = W * P;
            int Bcompany = 0;
            if (W <= R) {
                Bcompany = Q;
            }else Bcompany = Q+(W-R)*S;

            if (Acompany >= Bcompany) {
                System.out.println("#" + test_case + " " + Bcompany);
            }else System.out.println("#" + test_case + " " + Acompany);


        }

    }
}
