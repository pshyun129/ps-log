package swea.d5.p1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1247_ver2 {
    static int N;
    static Point[] points;
    static Point home, comp;
    static boolean[] visited;
    static int min;

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static void dfs(int cnt, int sum, int bx, int by){
        if (cnt == N) {
            // 집 경로 sum에 추가하고
            sum += Math.abs(bx - home.x) + Math.abs(by - home.y);

            // 최솟값 비교 후
            min = Math.min(min, sum);

            // 종료
            return;

        }

        for (int i = 0; i < N; i++) {
            if(visited[i])continue;
            visited[i] = true;
            int nSum = sum + Math.abs(bx - points[i].x) + Math.abs(by - points[i].y);
            dfs(cnt + 1, nSum, points[i].x, points[i].y);

            visited[i] = false;


        }




    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            comp = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            visited = new boolean[N];

            points = new Point[N];
            for (int i = 0; i < N; i++) {
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }


            min = Integer.MAX_VALUE;
            dfs(0, 0, comp.x, comp.y);
            sb.append("#").append(test_case).append(" ").append(min).append("\n");

        }
        System.out.print(sb);

    }
}
