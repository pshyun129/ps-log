package algorithm.ch03.bj2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int fun(int n) {
        int start= 1;
        int end = 1;
        //int sum  = 0;
        int sum = 1;
        int count = 0;

        while (start <= n) {

            /*if (start == end) {
                sum = start;
            } else {
                sum +=end;
            }
            if (sum > n) {
                start++;
                end = start;
                sum = 0;
                continue;
            } else if (sum == n) {
                count++;
                start++;
                end = start;
                sum = 0;
                continue;
            } else {
                end++;
            }*/

            if (sum == n) {
                count++;
                end++;
                sum +=end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum+=end;

            }

        }
        return count;



    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        /*int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }*/
        int result = fun(N);
        System.out.print(result);




    }
}
