package algorithm.ch_search.bj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static List<Integer> list;
    static int count;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    static void bfs(Point a, int N) {

        count =1;
        Queue<Point> q = new LinkedList<>();

        q.offer(a);
        visited[a.x][a.y] = true;

        while (!q.isEmpty()) {
            Point b = q.poll();

            //상
            if (b.x - 1 > 0 && visited[b.x - 1][b.y] == false) {
                q.offer(new Point(b.x - 1, b.y));
                visited[b.x -1][b.y] = true;
                count++;
            }

            //하
            if (b.x + 1 <= N && visited[b.x + 1][b.y] == false) {
                q.offer(new Point(b.x + 1, b.y));
                visited[b.x + 1][b.y] = true;
                count++;
            }

            //좌
            if (b.y - 1 > 0 && visited[b.x][b.y - 1] == false) {
                q.offer(new Point(b.x, b.y - 1));
                visited[b.x][b.y - 1] = true;
                count++;
            }

            //우
            if (b.y + 1 <= N && visited[b.x][b.y + 1] == false) {
                q.offer(new Point(b.x, b.y + 1));
                visited[b.x][b.y + 1] = true;
                count++;
            }

        }




    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    //지도의 크기

        visited = new boolean[N + 1][N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == '0') {
                    visited[i][j+1] = true;
                }
            }
        }

        int cof = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[i][j] == false) {
                    bfs(new Point(i, j), N);
                    list.add(count);
                    cof++;
                }


            }
        }

        Collections.sort(list);


        System.out.println(cof);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }







    }
}
