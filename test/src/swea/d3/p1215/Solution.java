package swea.d3.p1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int search(char[][] arr, int N) {
        int result = 0;


        //가로 검사
        for (int i = 0; i < 8; i++) {
            int pl = 0;
            int pr = N-1;
            outer : for (int j = 0; j < 8 - N + 1; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[i][j + k] != arr[i][j + N - 1 - k]) {

                        continue outer;
                    }
                }
                result++;
            }
        }

        //세로 검사
        for (int i = 0; i < 8; i++) {
            int pl = 0;
            int pr = N-1;
            outer : for (int j = 0; j < 8 - N + 1; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j+k][i] != arr[j+N-1-k][i]) {
                        continue outer;
                    }
                }
                result++;
            }
        }


        return result;

    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {

            int N = Integer.parseInt(br.readLine());    //회문의 길이

            char[][] arr = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String s = br.readLine();

                for (int j = 0; j < 8; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            int result = search(arr, N);
            System.out.println("#"+test_case+" "+result);






        }




    }

}
