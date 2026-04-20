package swea.mockTest.beatA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p2252 {
    static int N, M;
    static List<Integer>[] list;
    static int[] degree;
    static List<Integer> answer;


    static void bfs(){

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                answer.add(i);

            }
        }

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i : list[a]) {
                degree[i]--;
                if (degree[i] == 0) {
                    answer.add(i);
                    q.offer(i);
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        degree = new int[N + 1];

        answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            degree[b]++;
        }

        bfs();

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }


    }
}
