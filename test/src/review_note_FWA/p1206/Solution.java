package review_note_FWA.p1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());


            }



            int count = 0;

            for (int i = 2; i <= N - 3; i++) {

                int max = 0;
                for (int j = i - 2; j <= i + 2; j++) {
                    if (j == i) continue;
                    if (arr[j] > max) {
                        max = arr[j];
                    }
                }
                if (arr[i] - max > 0) {
                    count += arr[i] - max;
                }
            }

            System.out.println("#"+test_case+" "+count);




        }



    }
}
