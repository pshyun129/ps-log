package swea.d3.p1860;

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

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());   //몇명의 사람이 오는지
            int M = Integer.parseInt(st.nextToken());   //m초의 시간을 들이면
            int K = Integer.parseInt(st.nextToken());   //k개의 붕어빵을 만들수 있음

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];


            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int[] check = new int[arr[N - 1]+1];

            for (int i = 0; i < N; i++) {
                check[arr[i]]++;

            }

            int bread = 0;
            boolean check2 = true;
            for (int i = 0; i < check.length; i++) {
                if (i % M == 0 && i !=0) {      //0초에는 빵이 생산되면 안되...
                    bread+=K;
                }
                bread = bread - check[i];

                if (bread < 0) {
                    check2 = false;
                    break;
                }
            }

            if (check2 == true) {
                System.out.println("#"+test_case+" Possible");
            }else System.out.println("#"+test_case+" Impossible");



        }


    }
}
