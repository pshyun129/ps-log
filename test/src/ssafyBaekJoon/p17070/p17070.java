package ssafyBaekJoon.p17070;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p17070 {
    static int N;
    static int[][] arr;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 1, 0};
    static Pipe p;
    static int count;



    static class Pipe{
        int x;
        int y;
        int dist;	// 0 : 우, 1 : 우하, 2 : 하


        public Pipe(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

    }



    static void dfs(Pipe p1) {
        if(p1.x == N-1 && p1.y == N-1) {
            count++;
            return;
        }


        for(int d = 0; d < 3; d++) {
            int nx = p1.x + dx[d];
            int ny = p1.y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == 1)continue;
            // 대각선인 경우
//			if(d == 1) {
//				for(int k = 0; k < 3; k++) {
//					int n2x = p1.x + dx[d];
//					int n2y = p1.y + dy[d];
//					if(arr[n2x][n2y] == 1 ) continue offer;
//
//				}
//			}
            if (d == 1) {
                if (arr[p1.x][p1.y + 1] == 1 || arr[p1.x + 1][p1.y] == 1) continue;
            }

            if(p1.dist == 0 && d == 2) continue;
            if(p1.dist == 2 && d == 0) continue;

//			System.out.println(nx + " " + ny + " " + d + " ");
            dfs(new Pipe(nx, ny, d));



        }



    }
//	static void dfs() {
//		if(p.x == N-1 && p.y == N-1) {
//			count++;
//			return;
//		}
//
//
//		for(int d = 0; d < 3; d++) {
//			int nx = p.x + dx[d];
//			int ny = p.y + dy[d];
//
//			if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] == 1)continue;
//			if(p.dist == 0 && d == 2) continue;
//			if(p.dist == 2 && d == 0) continue;
//
//			System.out.println(nx + " " + ny + " " + d + " ");
//
//			int bx = p.x;
//			int by = p.y;
//			int bd = p.dist;
//
//			p.x = nx;
//			p.y = ny;
//			p.dist = d;
//
//			dfs();
//
//			p.x = bx;
//			p.y = by;
//			p.dist = bd;
//
//
//		}
//
//
//
//	}


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N;j++) {
                if(Integer.parseInt(st.nextToken()) == 1) {
                    arr[i][j] = 1;
                }
            }
        }

        count = 0;
        dfs(new Pipe(0, 1, 0));
//		p = new Pipe(0, 1, 0);
//		dfs();
        System.out.println(count);









    }

}
