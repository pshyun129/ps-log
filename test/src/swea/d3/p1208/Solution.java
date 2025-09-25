package swea.d3.p1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {

            int N = Integer.parseInt(br.readLine());    //시행 횟수

            st = new StringTokenizer(br.readLine());
            int[] a = new int[100];

            for (int i = 0; i < 100; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }


            for (int i = 1; i <= N; i++) {
                int max = 0;
                int min = 0;
                for (int j = 1; j < 100; j++) {
                    if(a[j] > a[max]) max = j;
                    if(a[j] < a[min]) min = j;
                }
                a[min]++;
                a[max]--;


            }
            int idx =0;
            int idx2 = 0;

            for (int j = 1; j < 100; j++) {
                if (a[j] > a[idx]) idx = j;
                if (a[j] < a[idx2]) idx2 = j;
            }

            System.out.println("#"+test_case+" "+(a[idx]-a[idx2]));






        }


    }
}
