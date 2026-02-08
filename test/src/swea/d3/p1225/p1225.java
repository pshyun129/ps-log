package swea.d3.p1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1225 {
    static Queue<Integer> q;

    static void makePw(){

        int x = 1;

        while (true) {
            int tmp = q.poll();
            tmp = tmp - x;

            //x 1~5반복
            x++;
            if (x > 5) x = 1;

            //종료 조건
            if (tmp <= 0) {
                q.offer(0);
                break;
            }
            q.offer(tmp);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            q = new ArrayDeque<>();

            for (int i = 0; i < 8; i++) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            makePw();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append(q.poll()).append(" ");
            }

            System.out.printf("#%d %s\n", T, sb);

        }
    }
}
