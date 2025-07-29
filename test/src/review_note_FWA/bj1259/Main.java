package review_note_FWA.bj1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S ;


        while (true) {
            S = br.readLine();
            if (S.equals("0")) {
                break;

            }

            boolean check = true;
            for (int i = 0; i < S.length(); i++) {
                char a = S.charAt(i);
                char b = S.charAt(S.length() - 1 - i);
                if (a != b) {
                    check = false;
                    break;
                }
            }
            if (check == true) {
                System.out.println("yes");
            } else if (check == false) {
                System.out.println("no");
            }

        }


    }
}
