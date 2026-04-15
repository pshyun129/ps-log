package codetree.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p02 {
    static int N, M;
    static int[][] arr;
    static int answer;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean[][] visited;

    static void dfs(int x, int y, int move){
        if (x == N - 1 && y == M - 1) {
            answer = 1;
            return;

        }

        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])continue;
            visited[nx][ny] = true;
            dfs(nx, ny, move+1);
            visited[nx][ny] = false;


        }



    }


    static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] a = q.poll();

            if (a[0] == N - 1 && a[1] == M - 1) {
                return 1;
            }

            for (int d = 0; d < 2; d++) {
                int nx = a[0] + dx[d];
                int ny = a[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || arr[nx][ny] == 0)continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});


            }


        }

        return 0;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];
        visited[0][0] = true;
//        answer = 0;
//        dfs(0, 0, 1);

//        System.out.print(answer);

        System.out.print(bfs());
    }
}
