package ssafyBaekJoon.p1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1158 {

    static int N;
    static int K;

    static String getJosephus() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            count++;
            if (count == K) {
                sb.append(q.poll());
                if (!q.isEmpty()) sb.append(", ");
                count = 0;
            } else {
                q.offer(q.poll());
            }

        }
        sb.append(">");
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        System.out.println(getJosephus());
    }
}
