package ssafyBaekJoon.p1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class p1941 {
    static char[][] arr;
    static HashSet<String> set;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }


    }


    static void dfs(int cnt, String ans, int x, int y, int count) {
        // 종료조건
        if(cnt == 7) {
            System.out.println("결과까지는 왔음");
            if(count >=4) {
                set.add(ans);

            }
            return;
        }


        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny])continue;
            visited[nx][ny] = true;
            String nAns = ans + (nx + "") + (ny + "");
            if(arr[nx][ny] == 'S') {
                dfs(cnt+1, nAns, nx, ny, count+1);
            }else {
                dfs(cnt+1, nAns, nx, ny, count);

            }
            visited[nx][ny] = false;
        }
    }


    static int getAnswer() {

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                visited = new boolean[5][5];
                visited[i][j] = true;
                if(arr[i][j] == 'S') dfs(0, "", i, j, 0);
            }
        }


        return set.size();
    }




    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new char[5][5];


        for(int i = 0; i < 5; i++) {
            String s = br.readLine();
            for(int j = 0; j < 5; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        set = new HashSet<>();


        System.out.println(getAnswer());

    }
}