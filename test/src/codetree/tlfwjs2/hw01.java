package codetree.tlfwjs2;

/*
 * 4방위 탐색
 * 다음 언덕이 top 인 경우
 * 다음 언덕이 현재 언덕보다 큰 경우
 *
 * 다음 언덕이 현재 언덕보다 작은 경우
 *
 *
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class hw01 {
    static int N, K;
    static int[][][] arr;
    static int top;
    static List<int[]> highest;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max;







    static void dfs(int move, int pounch, int x, int y) {		// move : 움직인 거리, pounch : 부술 수 있는 횟수(남은 횟수)

        boolean canMove = false;


        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny][pounch] == top)continue;

            int tmp = arr[nx][ny][pounch];

            if(arr[nx][ny][pounch] >= arr[x][y][pounch]) {
                if(arr[nx][ny][pounch] - arr[x][y][pounch] +1<= pounch) {
                    arr[nx][ny][pounch-(tmp -arr[x][y][pounch]+1)] = arr[x][y][pounch] - 1;
                    dfs(move+1, pounch-(tmp -arr[x][y][pounch]+1), nx, ny);
                    canMove = true;
                    arr[nx][ny][pounch-(tmp -arr[x][y][pounch]+1)] = tmp;
                }

            }else {
                dfs(move+1, pounch, nx, ny);
                canMove = true;
            }
        }


        if(!canMove) {
            max = Math.max(max, move);

            return;
        }
    }

    static void getAns() {
        for(int i = 0; i < highest.size(); i++) {
            int[] a = highest.get(i);
            dfs(0, K, a[0], a[1]);
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N][K+1];

        highest = new ArrayList<>();

        top = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                for (int k = 0; k <= K; k++) {
                    arr[i][j][k] = a;
                }

                top = Math.max(arr[i][j][0], top);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j][0] == top) {
                    highest.add(new int[] {i, j});
                }
            }
        }

        max = Integer.MIN_VALUE;

        getAns();
        System.out.println(max);




    }
}
