package algorithm.ch03.bj10986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //int[] arr = new int[N];
        long[] sum = new long[N + 1];
        long[] count = new long[M];

        st = new StringTokenizer(br.readLine());

 /*       for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }*/

        //합배열 + 각각 M으로 나눈 나머지로
        sum[0] = 0;
        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken()))%M;

        }

        int count2 = 0;

        for (int i = 1; i <= N; i++) {
            if (sum[i] == 0) {
                count2++;

            }
            count[(int)sum[i]]++;
        }
        long result = 0;
        for (int i = 0; i < M; i++) {
            result+=count[i]*(count[i]-1)/2;
        }

        System.out.print(result+count2);



/*        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (j < i) continue;

                if ((sum[j] - sum[i - 1]) % M == 0) {
                    count++;
                }
            }
        }*/
        //System.out.print(count);


    }
}
