package ssafyBaekJoon.p1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1697 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;
        if (N <= K) {
            a = K / N - 1;
            b = K % N;
            System.out.println(a + b);
        } else {
            a = N / K -1;
            b = N % K;
            System.out.println(a + b);
        }



    }
}
