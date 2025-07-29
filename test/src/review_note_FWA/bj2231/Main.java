package review_note_FWA.bj2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean found = false;
        for (int i = 0; i < N; i++) {
            int sum = 0 ;

            int number = i;
            while (true) {
                sum = sum + number % 10;


                number = number/10;


                if (number == 0) {
                    break;
                }

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
