package algorithm.ch_search.bj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] list;
    static int answer;
    static boolean[] visited;


    static void dfs(int a) {


        if (visited[a]) {
            return;
        }
        visited[a] = true;

        answer++;

        for (int i : list[a]) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());    //컴퓨터 개수
        int M = Integer.parseInt(br.readLine());    //간선 수
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();

        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            list[a1].add(a2);
            list[a2].add(a1);

        }

        visited = new boolean[N + 1];

        dfs(1);

        System.out.println(answer-1);




    }
}
