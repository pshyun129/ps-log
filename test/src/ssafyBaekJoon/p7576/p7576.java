package ssafyBaekJoon.p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7576 {
    static int N, M;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;

    static int bfs() {
        int time = 0;

        while (!q.isEmpty()) {

            boolean change = false;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] point = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = point[0] + dx[d];
                    int ny = point[1] + dy[d];

                    if(nx < 0 || nx >= M || ny < 0 || ny >= N || arr[nx][ny] != 0) continue;

                    arr[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                    change = true;
                }
            }
            if(change)time++;

        }
        if(check()) return time;

        return -1;
    }

    static boolean check() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 열
        M = Integer.parseInt(st.nextToken());   // 행

        arr = new int[M][N];
        q = new ArrayDeque<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) q.offer(new int[]{i, j});
            }
        }
        int result = bfs();

        System.out.print(result);





    }
}
