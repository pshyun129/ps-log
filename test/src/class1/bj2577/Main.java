package class1.bj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        String product = (a*b*c) + "";

        String[] digits = product.split("");

        int[] arr = new int[10];
/*

        for (int i = 0; i < st.countTokens(); i++) {

            int d = Integer.parseInt(st.nextToken());

            switch (d) {
                case 0:
                    arr[0]++;
                    break;
                case 1:
                    arr[1]++;
                    break;
                case 2:
                    arr[2]++;
                    break;
                case 3:
                    arr[3]++;
                    break;
                case 4:
                    arr[4]++;
                    break;
                case 5:
                    arr[5]++;
                    break;
                case 6:
                    arr[6]++;
                    break;
                case 7:
                    arr[7]++;
                    break;
                case 8:
                    arr[8]++;
                    break;
                case 9:
                    arr[9]++;
                    break;
            }

        }
*/


        for (int i = 0; i < digits.length; i++) {
            int d = Integer.parseInt(digits[i]);
            arr[d]++;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }



    }
}
