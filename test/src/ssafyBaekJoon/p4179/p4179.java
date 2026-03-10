package ssafyBaekJoon.p4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p4179 {
    static int R, C;
    static char[][] arr;
    static Queue<int[]> jh, fire;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};



    static int bfs(){
        int time = 0;
        boolean move = false;

        while (!jh.isEmpty()) {
            move = false;

            // 불 확산
            int fSize = fire.size();
            for (int i = 0; i < fSize; i++) {
                int[] point = fire.poll();


                for (int d = 0; d < 4; d++) {
                    int nx = point[0] + dx[d];
                    int ny = point[1] + dy[d];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C || arr[nx][ny] == '#' || arr[nx][ny] == 'F')continue;
                    arr[nx][ny] = 'F';
                    fire.offer(new int[]{nx, ny});
                }
            }

            // 지훈이 이동
            int jSize = jh.size();
            for (int i = 0; i < jSize; i++) {
                int[] point2 = jh.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = point2[0] + dx[d];
                    int ny = point2[1] + dy[d];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) return time+1;
                    if(arr[nx][ny] != '.')continue;
                    arr[nx][ny] = 'J';
                    move = true;
                    jh.offer(new int[]{nx, ny});
                }
            }
            if (move) {
                time++;
            }


        }
        return -1;
    }





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());   // 행
        C = Integer.parseInt(st.nextToken());   // 열

        arr = new char[R][C];

        jh = new ArrayDeque<>();
        fire = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
                if(arr[i][j] == 'J') jh.offer(new int[]{i, j});
                if(arr[i][j] == 'F') fire.offer(new int[]{i, j});
            }
        }

        int result = bfs();
        if (result == -1) {
            System.out.print("IMPOSSIBLE");
        }else System.out.print(result);



    }
}
