package algorithm.ch03.bj1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int fun(int m, int[] arr) {
        int pl = 0;
        int pr = arr.length-1;
        int count = 0;

        while (pl < pr) {

            if (arr[pl] + arr[pr] == m) {
                count++;
                pr--;
                pl++;
            } else if (arr[pl] + arr[pr] > m) {
                pr--;
            } else if(arr[pl] + arr[pr] < m) {
                pl++;
            }

/*            if (arr[pl] + arr[pr] == m) {
                count++;
                if (pr == arr.length) {
                    pl++;
                    pr = pl+1;
                }else pr++;
            } else if (arr[pl] + arr[pr] > m) {
                pl++;
                pr= pl+1;
            } else if(arr[pl] + arr[pr] < m) {
                if (pr == arr.length) {
                    pl++;
                    pr = pl+1;
                }else pr++;
            }*/




        }
        return count;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = fun(M, arr);

        System.out.print(result);



    }
}
