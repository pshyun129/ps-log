package algoRM.backjoon.p1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x;
    static int y;
    static int min;


    static void dfs(int nowPoint, int move, int count) {
        if(move == 0) return;

        if (nowPoint >= y || nowPoint <= x) {
            return;
        }

        // 종료 조건
        if (nowPoint == y - 1) {
            min = Math.min(min, count);
        }


        dfs(nowPoint + move + 1, move +1, count + 1);
        dfs(nowPoint + move, move, count + 1);
        dfs(nowPoint + move - 1, move - 1, count + 1);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            min = Integer.MAX_VALUE;

            dfs(x + 1, 1, 0);

            sb.append(min + 2).append("\n");
        }

        System.out.print(sb);


    }
}
