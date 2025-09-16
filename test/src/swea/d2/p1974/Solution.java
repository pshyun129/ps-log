package swea.d2.p1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static boolean check(int[][] arr) {

        //가로 검사
        for (int i = 0; i < 9; i++) {
            boolean[] fcheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int val = arr[i][j];
                if (fcheck[val] == true) {
                    return false;
                }
                fcheck[val] = true;

            }
        }
        // 세로 검사
        for (int i = 0; i < 9; i++) {
            boolean[] fcheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int val = arr[j][i];
                if (fcheck[val] == true) {
                    return false;
                }
                fcheck[val] = true;

            }
        }

        //3x3검사
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                boolean[] fcheck = new boolean[10];
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        int val = arr[i][j];
                        if (fcheck[val]) return false;
                        fcheck[val] = true;
                    }
                }
            }
        }
        return true;





    }






    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());



        for (int i = 0; i < T; i++) {

            int[][] sudoku = new int[9][9];


            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    sudoku[j][k] = Integer.parseInt(st.nextToken());
                }
            }


            boolean result = check(sudoku);
            if (result == false) {
                System.out.println("#" + (i + 1) + " 0");

            }else System.out.println("#" + (i + 1) + " 1");

        }

    }
}
