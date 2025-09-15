package swea.d1.p2072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {

                int a = Integer.parseInt(st.nextToken());
                if (a % 2 != 0) {
                    sum += a;

                }



            }
            System.out.println("#" + (i+1) + " " + sum);
        }

    }
}
