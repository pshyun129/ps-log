package algorithm.ch03.bj11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //표 크기
        int M = Integer.parseInt(st.nextToken());   //합을 구해야 하는 횟수

        int[][] arr = new int[N+1][N+1];
        int[][] sum = new int[N + 1][N + 1];

        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
/*        for (int i = 0; i < N; i++) {
            sum[0][i] = 0;
            sum[i][0] = 0;
        }*/  //자바에서 배열을 만들면 기본으로 0으로 초기화 되서 필요 x

/*        for (int i = 1; i <= N; i++) {
            sum[1][i]= sum[1][i-1] + arr[1][i-1];
            sum[i][1] = sum[i-1][1] + arr[i-1][1];
        }*/

        for (int i = 1; i <= N; i++) {              //i, j를 2가아니라 1로 놔두고 아래처럼 돌리면
            for (int j = 1; j <= N; j++) {          //위에 for문도 필요 x 결국 같은 효과임
                sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + arr[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            System.out.println(result);


        }



    }
}
