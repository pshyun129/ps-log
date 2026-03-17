package swea.mockTest.p5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5656 {
    static int N, W, H;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min;
    static int[] arr2;

    static int count(){
        int answer = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if(arr[i][j] > 0) answer++;
            }
        }

        return answer;
    }

    static void copyArr(int[][] a, int[][] b) {     // a 배열 값을 b에 복사
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                b[i][j] = a[i][j];
            }
        }
    }

    static void boom(int i, int j, int range){
        arr[i][j] = 0;

        for (int d = 0; d < 4; d++) {

            for (int k = 0; k < range; k++) {
                int nx = i + dx[d]*k;
                int ny = j + dy[d]*k;

                if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                if (arr[nx][ny] != 0) {
                    boom(nx, ny, arr[nx][ny]);
                }
            }
        }
    }

    static void slide(){

        for (int i = 0; i < W; i++) {
            int idx = 0;
            arr2 = new int[H];
            for (int j = H - 1; j >= 0; j--) {
                if (arr[j][i] != 0) {
                    arr2[idx++] = arr[j][i];
                }
            }

            for (int j = H - 1; j >= 0; j--) {
                 arr[j][i] = arr2[H-j-1];
            }
        }
    }



    static void dfs(int cnt){
        if (min == 0) return;

        // 종료 조건
        if (cnt == N) {
            // 남은 벽돌의 개수를 세고 최솟값을 갱신한 후
            min = Math.min(min, count());

            //종료
            return;
        }



        for (int i = 0; i < W; i++) {
            // 배열 백업
            int[][] backup = new int[H][W];
            copyArr(arr, backup);

            // i 위치에 떨어트렸을 때 배열에 반영
            for (int j = 0; j < H; j++) {
                if (arr[j][i] != 0) {
                    boom(j, i, arr[j][i]);
                    break;
                }
            }

            // 슬라이드
            slide();

            dfs(cnt+1);
            // 배열 원복
            copyArr(backup, arr);

        }




    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());   // 열
            H = Integer.parseInt(st.nextToken());   // 행

            arr = new int[H][W];



            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;

            dfs(0);

//            System.out.println(min);

            sb.append("#").append(test_case).append(" ").append(min).append("\n");


        }
        System.out.print(sb);

    }
}
