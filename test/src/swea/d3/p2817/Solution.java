package swea.d3.p2817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr;
    static int answer;
    static int N;
    static int K;


    static void findCase(int idx, int sum) {


        //답을 찾았을때
        if (sum == K) {
            answer++;
            return;
        }

        //전부 돌았을 때 종료 조건
        if (idx == N) {
            return;
        }

        //선택했을때
        findCase(idx+1, sum+arr[idx]);

        //선택 안했을때
        findCase(idx+1, sum);

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            answer = 0;

            findCase(0,0);

            System.out.println("#"+test_case+" "+answer);




        }



    }
}
