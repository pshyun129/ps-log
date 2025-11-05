package algorithm.ch_search.bj2178_S;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static boolean[][] visited;
    static int[][] dist;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }

    static void bfs(Point a, int N, int M) {

        Queue<Point> q = new LinkedList<>();

        q.offer(a);

        visited[1][1] = true;
        dist[1][1] = 1;

        while (!q.isEmpty()) {

            Point b = q.poll();

            //상
            if (b.x - 1 > 0 && visited[b.x - 1][b.y] == false) {
                q.offer(new Point(b.x - 1, b.y));
                visited[b.x-1][b.y] = true;
                dist[b.x-1][b.y] = dist[b.x][b.y]+1;
            }

            //하
            if (b.x + 1 <= N && visited[b.x + 1][b.y] == false) {
                q.offer(new Point(b.x + 1, b.y));
                visited[b.x+1][b.y] = true;
                dist[b.x+1][b.y] = dist[b.x][b.y]+1;
            }

            //좌
            if (b.y - 1 > 0 && visited[b.x][b.y - 1] == false) {
                q.offer(new Point(b.x , b.y - 1));
                visited[b.x][b.y-1] = true;
                dist[b.x][b.y - 1] = dist[b.x][b.y]+1;
            }

            //우
            if (b.y + 1 <= M && visited[b.x][b.y + 1] == false) {
                q.offer(new Point(b.x , b.y + 1));
                visited[b.x][b.y+1] = true;
                dist[b.x][b.y + 1] = dist[b.x][b.y]+1;
            }




        }





    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   //행
        int M = Integer.parseInt(st.nextToken());   //열

        dist = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == '0') {
                    visited[i][j+1] = true;
                }
            }
        }
        bfs(new Point(1, 1), N, M);

        System.out.println(dist[N][M]);






    }
}
