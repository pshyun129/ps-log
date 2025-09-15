package swea.d2.p1984;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 10; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            double sum =0;
            for (int j = 1; j < 9; j++) {
                sum += arr[j];
            }
            long result = Math.round(sum / 8.0);
            System.out.println("#"+(i+1)+" "+result);


        }



    }
}
