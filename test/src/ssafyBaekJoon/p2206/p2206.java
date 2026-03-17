package ssafyBaekJoon.p2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2206 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x;
        int y;
        boolean can;

        public Point(int x, int y, boolean can) {
            this.x = x;
            this.y = y;
            this.can = can;
        }
    }



    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        int[][][] dist = new int[N][M][2];  // 0 : 안부숨, 1 : 부숨

        q.offer(new Point(0, 0, true));
        dist[0][0][0] = 1;
        dist[0][0][1] = 0;


        while (!q.isEmpty()) {

            Point p = q.poll();
            int state = (p.can)? 0 : 1;
//            System.out.println("x : "+ p.x + ", y : " + p.y + ", can : " + p.can);
            if(p.x == N-1 && p.y == M-1) {
                return (dist[N-1][M-1][state] == 0) ? -1 : dist[N-1][M-1][state];
            }


            for (int d = 0; d < 4; d++) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
//                boolean can2 = p.can;

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || dist[nx][ny][state] != 0)continue;
                if (arr[nx][ny] == 1) {
                    if (p.can) {
                        dist[nx][ny][1] = dist[p.x][p.y][0] + 1;
                        q.offer(new Point(nx, ny,false));
                        continue;
                    }else continue;
                }
                dist[nx][ny][state] = dist[p.x][p.y][state] + 1;
                q.offer(new Point(nx, ny,p.can));


            }




        }



        return -1;

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }

        }

        System.out.println(bfs());



    }
}
