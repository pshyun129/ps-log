package swea.mockTest.p1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p1249 {
    static int N;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static class Point implements Comparable<Point>{
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


    static int dj(){

        PriorityQueue<Point> pq = new PriorityQueue<>();
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = arr[0][0];
        pq.offer(new Point(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {

            Point p = pq.poll();

            if (p.sum != dist[p.x][p.y]) {
                continue;
            }

            if(p.x == N-1 && p.y == N - 1) break;

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >=N)continue;

                int ndist = dist[p.x][p.y] + arr[nx][ny];

                if (ndist < dist[nx][ny]) {
                    dist[nx][ny] = ndist;
                    pq.offer(new Point(nx, ny, ndist));
                }

            }

        }
        return dist[N - 1][N - 1];
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }

            }

            int result = dj();
            System.out.println("#" + test_case + " " + result);





        }


    }
}
