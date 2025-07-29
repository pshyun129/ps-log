package review_note_FWA.bj2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st1;


        for (int i = 0; i < T; i++) {

            String S = br.readLine();
            st1 = new StringTokenizer(S);

            int R = Integer.parseInt(st1.nextToken());

            String S2 = st1.nextToken();


            for (int j = 0; j < S2.length(); j++) {
                for (int k = 0; k < R; k++) {
                    System.out.print(S2.charAt(j));
                }

            }
            System.out.println();




        }


    }
}
