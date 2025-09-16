package swea.d2.p1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SolutionF {

    static int check(int[][] arr) {
        //가로 검사
        for (int i = 1; i <= 9; i++) {
            if ((arr[9][i] - arr[9][i - 1]) != 45) {
                return -1;
            }
        }

        //세로 검사
        for (int i = 1; i <= 9; i++) {
            if ((arr[i][9] - arr[i - 1][9]) != 45) {
                return -1;
            }
        }

        //3x3검사
        for (int i = 3; i <= 9; i+=3) {

            for (int j = 3; j <= 9; j+=3) {
                if ((arr[i][j] - arr[i - 3][j] - arr[i][j - 3] + arr[i - 3][j - 3]) != 45) {
                    return -1;
                }
            }
        }
        return 1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());



        for (int i = 0; i < T; i++) {

            int[][] stocuSum = new int[10][10];


            for (int j = 1; j <= 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= 9; k++) {
                    stocuSum[j][k] = stocuSum[j-1][k]+stocuSum[j][k-1]-stocuSum[j-1][k-1] + Integer.parseInt(st.nextToken());
                }
            }
            int result = check(stocuSum);

            if (result == -1) {
                System.out.println("#" + (i + 1) + " 0");

            }else System.out.println("#" + (i + 1) + " 1");

        }

    }
}
