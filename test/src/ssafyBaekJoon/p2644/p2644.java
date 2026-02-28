package ssafyBaekJoon.p2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class p2644 {
    static int N, A, B;
    static List<Integer>[] list;
    static int[] dist;

    static void bfs(){
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(A);
        visited[A] = true;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i : list[a]) {
                if(visited[i]) continue;
                visited[i] = true;
                dist[i] = dist[a]+1;
                q.offer(i);
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 전체 사람의 수

        list = new ArrayList[N + 1];

        dist = new int[N + 1];  // 거리 계산 배열

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        // 계산해야 하는 두 사람의 번호
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        // 그래프 생성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs();


        if (dist[B] == 0) { // 0이면 이어지지 않았다는 뜻이니까 -1
            System.out.println(-1);
        }else System.out.println(dist[B]);



    }
}
