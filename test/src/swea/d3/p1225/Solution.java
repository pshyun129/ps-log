package swea.d3.p1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {





    static void makePw(int[] arr) {

        int a = 1;
        while (true) {
            int tmp = arr[0]-a;
            for (int i = 1; i < 8; i++) {
                arr[i-1] = arr[i];
            }
            arr[7] = tmp;

            if (tmp <= 0) {
                arr[7] = 0;
                break;
            }
            if (a < 5) {
                a++;
            }else a=1;

        }


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] arr = new int[8];

            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            makePw(arr);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 8; i++) {
                sb.append(arr[i]).append(" ");

            }

            System.out.println("#"+test_case+" "+sb);



        }

    }
}
