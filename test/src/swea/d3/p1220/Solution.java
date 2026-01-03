package swea.d3.p1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int test_case = 1; test_case <= 10; test_case++) {

            int T = Integer.parseInt(br.readLine());

            int[][] arr = new int[T][T];

            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < T; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int count = 0;


            for (int i = 0; i < T; i++) {
                boolean a = false;
                for (int j = 0; j < T; j++) {
                    if (arr[j][i] == 1) {
                        a = true;
                    }
                    if (arr[j][i] == 2 && a == true) {
                        count++;
                        a = false;
                    }
                }
                //System.out.println(count);

            }

            System.out.println("#"+test_case+" "+count);



        }


    }
}
