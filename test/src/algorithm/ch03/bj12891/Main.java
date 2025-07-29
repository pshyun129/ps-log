package algorithm.ch03.bj12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int func(String s, int p, int[] PWArr) {
        int pl = 0;
        int pr = pl+p-1;
        int[] arr2 = new int[4];

        int count = 0;

        while (pl + p -1 <= s.length()-1) {
            pr = pl+p-1;

            arr2[0] = arr2[1] = arr2[2] = arr2[3] = 0;      //초기화
            for (int i = pl; i <= pr; i++) {
                if (s.charAt(i) == 'A') {
                    arr2[0]++;
                } else if (s.charAt(i) == 'C') {
                    arr2[1]++;
                } else if (s.charAt(i) == 'G') {
                    arr2[2]++;
                } else if (s.charAt(i) == 'T') {
                    arr2[3]++;
                }
            }
            boolean result = true;
            for (int i = 0; i < 4; i++) {
                if (arr2[i] < PWArr[i]) {
                    result = false;
                }
            }
            if (result == true) {
                count++;
            }
            pl++;

        }

        return count;


    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String S1 = br.readLine();
        //char[] DNAArr = new char[S];
        int[] PWArr = new int[4];       //A, C, G, T

/*        for (int i = 0; i < S; i++) {
            DNAArr[i] = S1.charAt(i);
        }*/
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            PWArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = func(S1, P, PWArr);
        System.out.print(result);




    }
}
