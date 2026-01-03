package swea.d2.p1961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int[][] arr90;
    static int[][] arr180;
    static int[][] arr270;
    static int N;

    static void mk90() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr90[j][N-1-i] = arr[i][j];
            }
        }
    }

    static void mk180() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr180[N-1-i][N-1-j] = arr[i][j];
            }
        }
    }

    static void mk270() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr270[N-1-j][i] = arr[i][j];
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            arr90 = new int[N][N];
            arr180 = new int[N][N];
            arr270 = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            mk90();
            mk180();
            mk270();

            StringBuilder sb = new StringBuilder();

            sb.append("#"+test_case).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(arr90[i][j]);
                }
                sb.append(" ");

                for (int j = 0; j < N; j++) {
                    sb.append(arr180[i][j]);
                }
                sb.append(" ");

                for (int j = 0; j < N; j++) {
                    sb.append(arr270[i][j]);
                }
                sb.append("\n");
            }

            System.out.print(sb);

        }
    }
}
