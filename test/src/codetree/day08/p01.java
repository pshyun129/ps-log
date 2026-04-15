package codetree.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p01 {
    static int N, M;
    static List<Integer>[] list;
    static int[] out;
    static List<Integer> result;

    static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (out[i] == 0) {
                result.add(i);
                q.offer(i);
            }
        }

        while(!q.isEmpty()){

            int a = q.poll();

            for (int i : list[a]) {
                out[i]--;
                if (out[i] == 0) {
                    result.add(i);
                    q.offer(i);
                }
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        out = new int[N + 1];
        result = new ArrayList<>();

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            out[b]++;
        }

        bfs();

        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.print(sb);

    }
}
