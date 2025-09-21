package swea.d2.p1948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        int[] date = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());   //연도
            int b = Integer.parseInt(st.nextToken());   //날찌

            int c = Integer.parseInt(st.nextToken());   //2 연도
            int d = Integer.parseInt(st.nextToken());   //2 날짜

            int result = 0;

            for (int i = a; i <= c; i++) {
                if (i == a) {
                    result += date[i]-b+1;
                } else if (i == c) {
                    result += d;

                } else {
                    result += date[i];
                }
            }

            System.out.println("#"+test_case+" "+result);



        }


    }
}
