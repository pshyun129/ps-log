package swea.d3.p11315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static boolean[][] arr;
    static int N;


/*    static boolean findOmok() {
        //가로 찾기
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == true) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 5) {
                    return true;
                }
            }

        }

        //세로 찾기
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == true) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= 5) {
                    return true;
                }
            }

        }

        //대각선 찾기
        int[] dxX = {}


*//*        //대각선 찾기
        for (int i = 0; i < N; i++) {
            offer1 :for (int j = 0; j < N; j++) {
                int count1 = 0;
                int count2 = 0;
                if (arr[i][j] == true) {
                    count1++;
                    count2++;
                    for (int k = 1; k < 5; k++) {
                        if (i + k >= N || j + k >= N || j - k < 0) {
                            continue offer1;
                        }
                        //오른쪽 아래 대각선
                        if (arr[i + k][j + k] == true) {
                            count1++;
                        } else count1 = 0;

                        //왼쪽 아래 대각선
                        if (arr[i + k][j - k] == true) {
                            count2++;
                        } else count2 = 0;

                    }
                    if (count1 >= 5 || count2 >= 5) {
                        return true;
                    }

                }
            }
        }*//*

        return false;
    }*/

    static boolean findOmok() {
        int[] dr = {0, 1, 1, 1};
        int[] dc = {1, 0, 1, -1};

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!arr[r][c]) continue;

                for (int d = 0; d < 4; d++) {
                    boolean ok = true;

                    for (int k = 1; k < 5; k++) {
                        int nr = r + dr[d] * k;
                        int nc = c + dc[d] * k;

                        if (nr < 0 || nr >= N || nc < 0 || nc >= N || !arr[nr][nc]) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok) return true;
                }
            }
        }
        return false;
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            arr = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    if (s.charAt(j) == 'o') {
                        arr[i][j] = true;
                    }
                }
            }

            boolean answer = findOmok();
            if (answer == true) {
                System.out.println("#"+test_case+" YES");
            }else System.out.println("#"+test_case+" NO");



        }
    }
}
