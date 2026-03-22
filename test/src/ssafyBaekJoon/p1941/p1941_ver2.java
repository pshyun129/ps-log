package ssafyBaekJoon.p1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class p1941_ver2 {
    static char[][] arr;
    static int[][] result;
    static int count2;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean check() {
        boolean[] visited = new boolean[7];
        Queue<Integer> q = new ArrayDeque<>();

        visited[0] = true;
        q.offer(0);
        int connected = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next = 0; next < 7; next++) {
                if (visited[next]) continue;

                int dist = Math.abs(result[now][0] - result[next][0]) +
                        Math.abs(result[now][1] - result[next][1]);

                if (dist == 1) {
                    visited[next] = true;
                    q.offer(next);
                    connected++;
                }
            }
        }

        return connected == 7;
    }


    static void dfs(int cnt, int idx, int count) {
        if(count >= 4)return;

        if (cnt == 7) {
            // 뽑힌 점들이 붙어있는지 검사하고
            if (check()) {
                count2++;
            }
            return;
        }




        for (int i = idx; i < 25; i++) {
            int nx = i / 5;
            int ny = i % 5;
            result[cnt][0] = nx;
            result[cnt][1] = ny;

            if (arr[nx][ny] == 'Y') {
                dfs(cnt + 1, i + 1, count + 1);
            } else dfs(cnt + 1, i + 1, count);


        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        count2 = 0;
        result = new int[7][2];
        dfs(0, 0, 0);

        System.out.print(count2);


    }
}
