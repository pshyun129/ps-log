package ssafyBaekJoon.p4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485 {
    static int N;
    static int[][] arr;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int maxValue = Integer.MAX_VALUE;

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static void dijkstra() {

        PriorityQueue<Point> pq = new PriorityQueue<>();
        dist[0][0] = arr[0][0];

        pq.offer(new Point(0, 0, dist[0][0]));


        while (!pq.isEmpty()) {

            Point a = pq.poll();

            if(a.cost != dist[a.x][a.y]) continue;

            for (int d = 0; d < 4; d++) {
                int nx = a.x + dx[d];
                int ny = a.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int ndist = dist[a.x][a.y] + arr[nx][ny];

                if (dist[nx][ny] > ndist) {
                    dist[nx][ny] = ndist;
                    pq.offer(new Point(nx, ny, ndist));
                }


            }


        }




    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test_case = 0;
        while (true) {
            test_case++;
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            arr = new int[N][N];
            dist = new int[N][N];


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = maxValue;
                }
            }

            dijkstra();

            System.out.printf("Problem %d: %d\n", test_case, dist[N - 1][N - 1]);



        }




    }
}
