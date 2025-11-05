package algorithm.ch_search.bj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean[] visited2;


    static void DFS(int V) {

        if (visited[V]) {
            return;
        }
        visited[V] = true;
        System.out.print(V + " ");
        for (int j : graph[V]) {
            if (!visited[j]) {
                DFS(j);
            }
        }
    }


    static void BFS(int V, int N) {

        visited2 = new boolean[N + 1];

        Queue<Integer> q = new LinkedList<>();

        visited2[V] = true;

        q.offer(V);

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

/*            if (!visited2[node]) {
                visited2[node] = true;
                System.out.print(node + " ");

            }*/
            for (int i = 0; i < graph[node].size(); i++) {
                if (!visited2[graph[node].get(i)]) {
                    visited2[graph[node].get(i)]=true;
                    q.offer(graph[node].get(i));
                }
            }


        }

    }





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //정점의 개수
        int M = Integer.parseInt(st.nextToken());   //간선의 개수
        int V = Integer.parseInt(st.nextToken());   //탐색 시작 지점

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            graph[a1].add(a2);
            graph[a2].add(a1);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);


        }

        visited = new boolean[N + 1];

        DFS(V);
        System.out.println();
        BFS(V, N);


    }
}
