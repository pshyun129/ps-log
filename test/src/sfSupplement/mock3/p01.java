package sfSupplement.mock3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p01 {

    static int N, K;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int max;
    static int max1;

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }


    static void dfs(int cnt, int cut, int x, int y, boolean move) {

        if(!move) {




            return;
        }

        max = Math.max(cnt, max);

        int k = arr[x][y];	// 현재칸 크기


        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;

            int c = arr[nx][ny]; // 복구용
            // 바로 갈 수 있는 경우
            if(arr[nx][ny] < k) {
                visited[nx][ny] = true;
                dfs(cnt+1, cut, nx, ny, true);
            }else if(arr[nx][ny] >= k) {
                int ncut = cut;
                int b = arr[nx][ny];
                if (arr[nx][ny] == max1)continue;
                for(int i = 0; i < cut; i++) {
                    if(b < k) {
                        break;
                    }else {
                        if(ncut == 0 || b == 1) break;
                        b--;
                        ncut--;
                    }
                }
                if(b < k) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = b;
                    dfs(cnt+1, ncut, nx, ny, true);
                }else continue;


            }
            visited[nx][ny] = false;
            arr[nx][ny] = c;

        }


        dfs(cnt, cut, x, y, false);


    }


    static void copyArr(int[][] a, int[][] b) {
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++) {
                a[i][j] = b[i][j];
            }
        }
    }



    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());	// 산의 크기
        K = Integer.parseInt(st.nextToken());	// 깎을 수 있는 횟수

        arr = new int[N][N];
        List<Point> list = new ArrayList<>();


        max1 = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max1 = Math.max(max1, arr[i][j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N;j++) {
                if(arr[i][j] == max1) {
                    list.add(new Point(i, j));
                }
            }
        }

        max = Integer.MIN_VALUE;
        int[][] backup = new int[N][N];

        copyArr(backup, arr);

        for(int i = 0; i < list.size(); i++) {
            Point a = list.get(i);
            visited = new boolean[N][N];
            visited[a.x][a.y] = true;
            dfs(1, K, a.x, a.y, true);
            copyArr(arr, backup);

        }

        System.out.print(max);




    }
}