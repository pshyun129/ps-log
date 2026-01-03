package swea.d2.p12712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int answer;
    static int N;
    static int M;

    static void search() {
        answer = 0;

        int[] dxPlus = {-1, 1, 0, 0};
        int[] dyPlus = {0, 0, -1, 1};

        int[] dxX = {-1, -1, 1, 1};
        int[] dyX = {-1, 1, -1, 1};


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                //plus
                int sum = arr[i][j];
                for (int d = 0; d < 4; d++) {
                    for (int k = 1; k < M; k++) {

                        int dx1 = i + dxPlus[d]*k;
                        int dy1 = j + dyPlus[d]*k;

                        if (dx1 < 1 || dx1 > N || dy1 < 1 || dy1 > N) {
                            break;

                        }
                        sum += arr[dx1][dy1];
                    }
                }
                if (sum > answer) answer = sum;

                //cross
                int sum2 = arr[i][j];
                for (int d = 0; d < 4; d++) {
                    for (int k = 1; k < M; k++) {

                        int dx2 = i + dxX[d]*k;
                        int dy2 = j + dyX[d]*k;

                        if (dx2 < 1 || dx2 > N || dy2 < 1 || dy2 > N) {
                            break;

                        }
                        sum2 += arr[dx2][dy2];
                    }
                }
                if (sum2 > answer) answer = sum2;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());   //배열의 크기
            M = Integer.parseInt(st.nextToken());   //중심 포함, 각 방향으로 뿌려지는 칸수

            arr = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            search();
            System.out.println("#" + test_case + " " + answer);
        }
    }
}
