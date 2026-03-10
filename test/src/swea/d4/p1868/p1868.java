package swea.d4.p1868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1868 {
    static int N;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    static int countMine(int x, int y) {
        int cnt = 0;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (arr[nx][ny] == '*') cnt++;
        }

        return cnt;
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        // 숫자 칸이면 여기서 멈춤
        if (countMine(x, y) > 0) return;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (visited[nx][ny]) continue;
            if (arr[nx][ny] == '*') continue;

            dfs(nx, ny);
        }
    }

    static int getAnswer() {
        int answer = 0;

        // 0칸부터 클릭
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '*' || visited[i][j]) continue;

                if (countMine(i, j) == 0) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        // 남은 안전 칸은 각각 1번씩 클릭
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '.' && !visited[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            arr = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            int answer = getAnswer();
            System.out.println("#" + test_case + " " + answer);
        }
    }
}