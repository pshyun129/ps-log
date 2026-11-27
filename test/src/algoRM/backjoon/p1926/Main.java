package algoRM.backjoon.p1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;   // 세로
    static int M;   // 가로
    static int[][] arr; // 그림판 배열
    static int count;   // 그림의 갯수
    static int max;     // 가장 큰 그림의 크기
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};    // 상하죄우
    static int[] dy = {0, 0, -1, 1};



    static void bfs(int x, int y) {

        Queue<int[]> q = new ArrayDeque<>();

        visited[x][y] = true;
        q.offer(new int[]{x, y});

        int count2 = 1; // max계산용

        while (!q.isEmpty()) {
            int[] a = q.poll();


//            if(visited[a[0]][a[1]]) continue;

//            System.out.println(count + "\n" + max);

            for (int d = 0; d < 4; d++) {
                int nx = a[0] + dx[d];
                int ny = a[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                count2++;

                q.offer(new int[]{nx, ny});
            }

        }

        max = Math.max(max, count2);
    }


    static void getAnswer() {

        // 순환하면서 검사
        count = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                bfs(i, j);
                count++;

            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 세로크기
        M = Integer.parseInt(st.nextToken());   // 가로크기


        // 그림판 배열
        arr = new int[N][M];

        // 방문 체크 배열 생성
        visited = new boolean[N][M];

        // 배열 채우기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        getAnswer();
        System.out.println(count + "\n" + max);


    }

}
