package swea.d3.p1206;

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
            st = new StringTokenizer(br.readLine());
            int[] building = new int[N];


            for (int i = 0; i < N; i++) {
                building[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for (int i = 0; i < N - 4; i++) {
                int idx = i+2;
                int[] check = new int[5];


                int a = 0;
                for (int j = i; j < i + 5; j++) {
                    check[a] = building[j];
                    a++;
                }
                Arrays.sort(check);

                if (check[4] == building[idx]) {
                    result += building[idx]-check[3];

                }


            }
            System.out.println("#"+test_case+" "+result);




        }



    }
}
