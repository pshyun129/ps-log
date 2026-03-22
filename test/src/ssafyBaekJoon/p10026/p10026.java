package ssafyBaekJoon.p10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class p10026 {
//    static int[][] arr, arr2;       // R : 0, G : 1(arr2는 0), B : 2
    static int N;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int[][] arr, int x, int y, int a) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();


            for (int d = 0; d < 4; d++) {
                int nx = point[0] + dx[d];
                int ny = point[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if(arr[nx][ny] != a)continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }

        }
    }


    static int countGroup(int[][] arr){
        int count = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]){
                    bfs(arr, i, j, arr[i][j]);
                    count++;
                }


            }
        }

        return count;
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int[][] arr2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'R') {
                    arr[i][j] = 0;
                    arr2[i][j] = 0;
                } else if (s.charAt(j) == 'G') {
                    arr[i][j] = 1;
                    arr2[i][j] = 0;
                } else {
                    arr[i][j] = 2;
                    arr2[i][j] = 2;
                }
            }

        }

        System.out.print(countGroup(arr) + " " + countGroup(arr2));




    }
}
