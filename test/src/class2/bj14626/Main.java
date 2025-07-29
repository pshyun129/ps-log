package class2.bj14626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();


        int sum = 0;
        int i = 0;
        int t = 0;                          //*에 곱할 수
        for (i = 0; i < 12; i++) {
            if (S.charAt(i) == '*') {
                if (i % 2 == 0) {
                    t=1;
                    //System.out.println(t);
                    continue;
                } else {
                    t=3;
                    //System.out.println(t);
                    continue;
                }
            }
            if (i % 2 == 0) {                   //홀수면
                sum += (S.charAt(i) - '0');
                //System.out.println(sum);
            } else {                            //짝수면
                sum += 3 * (S.charAt(i) - '0');
                //System.out.println(sum);
            }

        }

        int m = S.charAt(12) - '0';


        for (int j = 0; j < 10; j++) {
            if (m == (10 - (sum + t * j) % 10)%10) {        //이게 결국 m이 0일때를 고려해야함
                System.out.print(j);
            }
        }


        /*//System.out.println(sum);

        sum += (S.charAt(12)-'0');

        //System.out.println(sum);
        int sum2 = 10 - sum%10;
        //System.out.println(sum2);

        if (t == 1) {
            System.out.print(sum2);
        } else {
            for (int j = 0; j < 10; j++) {
                if (((3 * j) % 10) == sum2) {
                    System.out.print(j);
                    break;
                }
            }

        }*/


    }
}
