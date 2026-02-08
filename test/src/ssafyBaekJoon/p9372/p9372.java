package ssafyBaekJoon.p9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p9372 {
    static List<Integer>[] list;
    static int N;
    static int M;


    //근데 항상 연결그래프이면 입력값과 상관없이 N-1이 답이긴 할 것 같다
    //사실상 간선의 개수가 최소 비행스케줄이기 때문에
    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        visited[1] = true;
        q.offer(1);

        int count = 0;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i : list[a]) {
                if(!visited[i]){
                    visited[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }


        return count;

    }
/*
    static void dfs(int cuntry) {
        visited[cuntry] = true;

        for (int i : list[cuntry]) {
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }


    }
*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   //국가의 수
            M = Integer.parseInt(st.nextToken());   //비행기의 종류

            list = new ArrayList[N+1];

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

            System.out.println(bfs());


        }



    }
}
