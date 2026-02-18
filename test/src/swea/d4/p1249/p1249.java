package swea.d4.p1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1249 {
    static int N;
    static int[][] arr;
    static int[][] dist;
    static int answer;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int sum;

        public Point(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.sum, o.sum);
        }
    }

    static void dijkstra() {

        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[0][0] = 0;

        pq.offer(new Point(0, 0, 0));

        while (!pq.isEmpty()) {

            Point a = pq.poll();

            // 구버전 point라면 스킵
            if (a.sum != dist[a.x][a.y]) {
                continue;
            }

            // 목적지에 도착했다면 종료
            if (a.x == N - 1 && a.y == N - 1) {
                answer = a.sum;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = a.x+dx[d];
                int ny = a.y+dy[d];

                // 만약 배열 범위를 넘어가거나 방문했던 곳이라면 continue
                if (nx < 0 || nx >= N || ny < 0 || ny >= N ) {
                    continue;
                }

                // newsum은 지금까지 왔던 시간 + 다음칸으로 가는데 드는 시간
                int newsum = dist[a.x][a.y] + arr[nx][ny];
                //갱신이 가능하면 갱신
                if (newsum < dist[nx][ny]) {
                    dist[nx][ny] = newsum;
                    pq.offer(new Point(nx, ny, dist[nx][ny]));
                }




            }

        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            answer = 0;

            dijkstra();
            System.out.printf("#%d %d\n", test_case, answer);

        }

    }
}
