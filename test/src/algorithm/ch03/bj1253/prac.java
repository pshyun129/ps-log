package algorithm.ch03.bj1253;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class prac {

    static int findGood(long[] arr) {
/*        int pl =0;
        int pr = 0;*/
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int pl = 0;
            int pr = i-1;

            while(pl < pr) {
                long sum = arr[pl] + arr[pr];

/*                if (pl == i) {
                    pl++;
                    continue;
                }
                if (pr == i) {
                    pr--;
                    continue;
                }*/


                if (sum == arr[i]) {
                    count++;
/*                    pl++;
                    pr--;*/
                    break;
                } else if (sum > arr[i]) {
                    pr--;
                } else if (sum < arr[i]) {
                    pl++;
                }
            }
        }
        return count;

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        //findGood(arr);
        System.out.print(findGood(arr));

    }
}
