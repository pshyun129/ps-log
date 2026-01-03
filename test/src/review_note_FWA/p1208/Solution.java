package review_note_FWA.p1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[100];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                Arrays.sort(arr);
                if (arr[0] == arr[99]) {
                    break;
                }
                arr[0]++;
                arr[99]--;

            }
            Arrays.sort(arr);
            System.out.println("#"+test_case+" "+(arr[99]-arr[0]));




        }

    }
}
