package swea.d3.p5215_NSY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2 {
    //static boolean[] visited;
    static int max;
    static int L;
    static int[] kcal;
    static int[] score;
    static int N;


    static void dfs(int a, int kSum, int sSum) {
        if (kSum  > L) {
            return;
        }

        if (a == N+1) {
            if (sSum > max) {
                max = sSum;
            }
            return;
        }


        //다음꺼를 선택한 경우
        dfs(a + 1, kSum + kcal[a], sSum + score[a]);

        //다음꺼를 선택 안한경우
        dfs(a + 1, kSum, sSum);








/*
        if (visited[a]) {
            return;
        }

        if (kSum + kcal[a] > L) {
            if (sSum > max) {
                max = sSum;

            }

            return;
        }


        visited[a] = true;
        kSum += kcal[a];
        sSum += score[a];



        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i, kSum, sSum);
            }


        }
*/




        }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());   //재료의 수
            L = Integer.parseInt(st.nextToken());   //제한 칼로리
            max = 0;

            score = new int[N + 1];
            kcal = new int[N + 1];
            //visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                int a1 = Integer.parseInt(st.nextToken());
                int a2 = Integer.parseInt(st.nextToken());

                score[i] = a1;
                kcal[i] = a2;

            }

            dfs(1, 0, 0);

            System.out.println("#"+test_case+" "+max);




        }


    }
}
