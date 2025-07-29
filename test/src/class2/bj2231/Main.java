package class2.bj2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N2 = Integer.parseInt(br.readLine());


/*        if (N2 == 1) {
            System.out.print(1);

        }*/

        int result = 0;

        for (int i = 0; i < N2 ; i++) {

            String test2 = i + "";
            int test3 = test2.length();//자릿수


            int sum = i;
            for (int j = 0; j < test2.length(); j++) {
                sum = sum + test2.charAt(j) - '0';
            }

            if (sum == N2) {
                result = i;
                break;

            }

        }
        System.out.print(result);


    }
}
