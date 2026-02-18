package swea.mockTest.p5648;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5648 {
    static int N;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][4];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    arr[i][0] = Integer.parseInt(st.nextToken());
                }
            }




        }


    }
}
