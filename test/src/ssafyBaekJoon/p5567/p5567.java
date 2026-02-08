package ssafyBaekJoon.p5567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p5567 {
    static List<Integer>[] list;
    static int n;
    static int m;
    static int[] dist;

    static int bfs(){
        int answer = 0;

        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(1);
        visited[1] = true;

        //1기준 거리 측정
        while (!q.isEmpty()) {

            int a = q.poll();

            for (int i : list[a] ) {
                if (visited[i] == false) {
                    visited[i] = true;
                    dist[i] = dist[a] + 1;
                    q.offer(i);
                }
            }
        }

        //거리가 1, 2이면 answer++, 거리 0 = 나, 거리 1 = 내 친구, 거리 2 = 친구의 친구
        for (int i = 1; i <= n; i++) {
            if (dist[i] == 1 || dist[i] == 2) {
                answer++;
            }
        }



        return answer;
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        dist = new int[n+1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);

        }


        System.out.println(bfs());



    }
}
