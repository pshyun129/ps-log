package class2.bj1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String S = br.readLine();
            if (S.equals("0")) {
                break;

            }
/*            if (S.length() % 2 != 1) {
                System.out.println("no");
                continue;
            }*/



            int[] arr = new int[S.length()];


            for (int i = 0; i < S.length(); i++) {
                arr[i] = S.charAt(i) - '0';;
            }

            boolean prove = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == arr[arr.length - 1 - i]) {
                    prove = true;

                } else {
                    prove =false;
                    break;
                }



            }
            if (prove == true) {
                System.out.println("yes");

            } else {
                System.out.println("no");
            }



        }


    }
}
