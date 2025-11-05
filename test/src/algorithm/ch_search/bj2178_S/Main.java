package algorithm.ch_search.bj2178_S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int answer=1;


    static void bfs(int a, int M, int N) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(a);

        int node = 0;
        while (node != (M*N)) {
            node = q.poll();

            //상
            if (node - M > 0 && visited[node - M] == false) {
                visited[node -M] = true;
                q.offer(node - M);
            }

            //하
            if (node + M < (M*N+1) && visited[node + M] == false) {
                visited[node + M] = true;
                q.offer(node + M);
            }

            //좌
            if (node - 1 > 0 && visited[node - 1] == false) {
                visited[node -1] = true;
                q.offer(node - 1);
            }

            //우
            if (node + 1 < (M*N+1) && visited[node + 1] == false) {
                visited[node + 1] = true;
                q.offer(node + 1);
            }






        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //행
        int M = Integer.parseInt(st.nextToken());   //열
        visited = new boolean[N * M + 1];

        int a = 1;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '0') {
                    visited[a] = true;
                }
                a++;
            }

        }


    }
}
