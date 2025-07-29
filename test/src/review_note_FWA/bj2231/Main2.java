package review_note_FWA.bj2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String S = br.readLine();

        int N = Integer.parseInt(S);

        boolean found = false;
        for (int i = 0; i < N; i++) {
            String A = i + "";

            int sum = 0;
            for (int j = 0; j < A.length(); j++) {
                sum = sum + (A.charAt(j)-'0');


            }
            int result = sum + i;

            if (result == N) {
                System.out.print(i);
                found = true;

                break;
            }

        }
        if (found == false) {
            System.out.print(0);
        }






    }
}
