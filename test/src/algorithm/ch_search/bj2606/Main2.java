package algorithm.ch_search.bj2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer;

    static void bfs(int a) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(a);
        visited[a] = true;

        while (!q.isEmpty()) {
            int node = q.poll();

/*            if (!visited[node]) {
                visited[node] = true;
                answer++;
                for (int i : list[node]) {
                    q.offer(i);
                }
            }*/
            for (int i : list[node]) {
                if (!visited[i]) {
                    visited[i]=true;
                    answer++;
                    q.offer(i);

                }
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

        bfs(1);
        System.out.println(answer);




    }
}
