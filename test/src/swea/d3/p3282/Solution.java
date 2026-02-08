package swea.d3.p3282;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int K;
    static int[] size;
    static int[] value;
    static int answer;

    static void findMaxValue(int idx, int sizeSum, int valSum) {



        if (sizeSum > K) {
            return;
        }

        if (idx == N) {
            if (valSum > answer) {
                answer = valSum;
            }
            return;
        }




        if (valSum > answer) {
            answer = valSum;
        }

        //선택
        findMaxValue(idx+1, sizeSum+size[idx], valSum+value[idx]);

        //선택 안함
        findMaxValue(idx+1, sizeSum, valSum);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            size = new int[N];
            value = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                size[i] = Integer.parseInt(st.nextToken());
                value[i] = Integer.parseInt(st.nextToken());

            }

            answer = 0;
            findMaxValue(0, 0, 0);
            System.out.println("#"+test_case+" "+answer);

        }
    }
}
