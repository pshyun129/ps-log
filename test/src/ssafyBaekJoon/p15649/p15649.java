package ssafyBaekJoon.p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p15649 {
    static int N;
    static int M;
    static int[] result;
    static boolean[] visited;
    static String s;

    static void dfs(int cnt) {
        if (cnt == M) {
            s = "";
            for (int i = 0; i < M; i++) {
                s = s + result[i] +" ";
            }
            System.out.println(s);
            return;
        }




        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[cnt] = i;
            dfs(cnt + 1);
            visited[i] = false;

        }



    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visited = new boolean[N + 1];

        dfs(0);

    }
}
