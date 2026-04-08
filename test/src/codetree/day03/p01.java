package codetree.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p01 {
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;
    static int count;

    static void dfs(int a){
        for (int i : list[a]) {
            if(visited[i])continue;
            visited[i] = true;
            count++;
            dfs(i);

        }


    }





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점
        M = Integer.parseInt(st.nextToken());   // 간선

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        count = 0;

        dfs(1);

        System.out.print(count);

    }
}
