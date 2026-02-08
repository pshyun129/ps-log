package sfSupplement.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class p01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());   //행
            int y = Integer.parseInt(st.nextToken());   //열
            arr[x][y] = 1;

            int count = 0;
            for (int d = 0; d < 4; d++) {
                if (x + dx[d] < 0 || x + dx[d] > N || y + dy[d] < 0 || y + dy[d] > N) {
                    continue;
                }
                if (arr[x + dx[d]][y + dy[d]] == 1) {
                    count++;
                }
            }

            if (count >= 3) {
                System.out.println(1);

            }else System.out.println(0);

        }



    }
}
