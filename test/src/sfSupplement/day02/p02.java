package sfSupplement.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p02 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        //시계방향
        int[] dx = { -1, 0 , 1, 0};
        int[] dy = {0, 1, 0, -1};
        int d = 0; 	//0 = 북, 1 = 동, 2 = 남, 3 = 서
        int x = 0;  //행
        int y = 0;  //열

        char[][] arr = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = s.charAt(j-1);
            }
        }

        int K = Integer.parseInt(br.readLine());

        if (1 <= K && K <= N) {                 // 위쪽: (1, K)로 들어와서 아래로
            x = 1; y = K; d = 2;                // 남(아래)
        } else if (K <= 2 * N) {                // 오른쪽: (K-N, N)로 들어와서 왼쪽으로
            x = K - N; y = N; d = 3;            // 서(왼쪽)
        } else if (K <= 3 * N) {                // 아래쪽: 오른쪽->왼쪽 (N, 3N-K+1)로 들어와서 위로
            x = N; y = 3 * N - K + 1; d = 0;    // 북(위)
        } else {                                 // 왼쪽: 아래->위 (4N-K+1, 1)로 들어와서 오른쪽으로
            x = 4 * N - K + 1; y = 1; d = 1;    // 동(오른쪽)
        }

        int count = 0;
        while (true) {
            char a = arr[x][y];
            if (a == '\\') {
                if (d == 0) {
                    d = 3;
                } else if (d == 2) {
                    d--;
                } else if (d == 1) {
                    d++;
                } else if (d == 3) {
                    d = 0;
                }
                x += dx[d];
                y += dy[d];
                count++;
            } else if (a == '/') {
                if (d == 0) {
                    d++;
                } else if (d == 2) {
                    d++;
                } else if (d == 1) {
                    d--;
                } else if (d == 3) {
                    d--;
                }
                x += dx[d];
                y += dy[d];
                count++;
            }
            if (x < 1 || x > N || y < 1 || y > N) {
                System.out.println(count);
                return;
            }


        }


    }
}
