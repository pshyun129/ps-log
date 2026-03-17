package ssafyBaekJoon.p1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1261 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int broken;

        public Point(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.broken, o.broken);
        }
    }

    static int dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>();

        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        pq.offer(new Point(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {

            Point p = pq.poll();

            // 더 안좋은 경우면 넘김
            if(p.broken > dist[p.x][p.y]) continue;

            // 종료 조건
            if(p.x == N-1 && p.y == M-1) return p.broken;

            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                int nBroken = p.broken + arr[nx][ny];
                if (dist[nx][ny] > nBroken) {
                    dist[nx][ny] = nBroken;
                    pq.offer(new Point(nx, ny, nBroken));

                }

            }



        }


        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 열
        N = Integer.parseInt(st.nextToken());   // 행

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s.charAt(j) + "");
            }
        }
        System.out.print(dijkstra());


    }

}
