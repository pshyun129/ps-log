package swea.d5.p1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1247 {
    static int N;
    static Point[] points;
    static Point home;
    static boolean[] visited;
    static int min;



    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    static void dfs(int cnt, int sum, int bx, int by) {
        // N번 하면 종료
        if (cnt == N) {
            sum += Math.abs(bx - home.x) + Math.abs(by - home.y);

            //min = Math.min(min, sum);

            if (sum < min) {
                min = sum;
            }
            return;
        }

        // 지금까지 게산한 값이 min보다 크면 종료
        if (sum + Math.abs(bx - home.x) + Math.abs(by - home.y) > min) return;






        // 선택
        for (int i = 1; i <= N; i++) {
            // 방문했던 곳이면 continue
            if(visited[i]) continue;

            visited[i] = true;
            dfs(cnt+1, sum + Math.abs(bx - points[i].x) + Math.abs(by - points[i].y), points[i].x, points[i].y);

            // 다음 선택에 영향 안주게 원복
            visited[i] = false;
        }




    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            points = new Point[N + 1];  //0은 회사, 1부터 N까지는 고객
            visited = new boolean[N + 1];

            st = new StringTokenizer(br.readLine());
            points[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 1; i <= N; i++) {
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }


            min = Integer.MAX_VALUE;

            dfs(0, 0, points[0].x, points[0].y);

            System.out.printf("#%d %d\n", test_case, min);

        }


    }
}
