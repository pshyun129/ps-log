package swea.d3.p3260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            //A, B의 자릿수
            int i = A.length() - 1;
            int j = B.length() - 1;

            //올림
            int carry = 0;

            StringBuilder sb = new StringBuilder();

            while (i >= 0 || j >= 0 || carry > 0) {
                //올림 반영
                int sum = carry;

                //각 자릿수 연산
                if(i >= 0) sum += A.charAt(i--) - '0';
                if(j >= 0) sum += B.charAt(j--) - '0';

                sb.append(sum % 10);
                carry = sum/10;

            }
            sb.reverse();
            System.out.printf("#%d %s\n", test_case, sb);


        }


    }



}
