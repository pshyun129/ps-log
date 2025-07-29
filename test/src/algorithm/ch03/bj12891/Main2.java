package algorithm.ch03.bj12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] MYArr;
    static int[] PWArr;
    static int check;


    static void add(char c) {
        if (c == 'A') {
            MYArr[0]++;
            if (MYArr[0] == PWArr[0]) {
                check++;
            }
        } else if (c == 'C') {
            MYArr[1]++;
            if (MYArr[1] == PWArr[1]) {
                check++;
            }
        } else if (c == 'G') {
            MYArr[2]++;
            if (MYArr[2] == PWArr[2]) {
                check++;
            }
        } else if (c == 'T') {
            MYArr[3]++;
            if (MYArr[3] == PWArr[3]) {
                check++;
            }
        }
    }

    static void rm(char c) {
        if (c == 'A') {
            if (MYArr[0] == PWArr[0]) {
                check--;
            }
            MYArr[0]--;
        } else if (c == 'C') {
            if (MYArr[1] == PWArr[1]) {
                check--;
            }
            MYArr[1]--;
        } else if (c == 'G') {
            if (MYArr[2] == PWArr[2]) {
                check--;
            }
            MYArr[2]--;
        } else if (c == 'T') {
            if (MYArr[3] == PWArr[3]) {
                check--;
            }
            MYArr[3]--;
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String S1 = br.readLine();
        char[] DNAArr = new char[S];
        PWArr = new int[4];       //A, C, G, T
        MYArr = new int[4];
        int result = 0;

        for (int i = 0; i < S; i++) {
            DNAArr[i] = S1.charAt(i);
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            PWArr[i] = Integer.parseInt(st.nextToken());
        }

        // check 초기값 설정
        for (int i = 0; i < 4; i++) {
            if (PWArr[i] == 0) {
                check++; // 0개 조건은 처음부터 만족하므로
            }
        }


        //맨 처음 검사부분
        for (int i = 0; i < P; i++) {
            add(DNAArr[i]);
        }
        if (check == 4) {
            result++;
        }

        //두번째부터 마지막까지

        for (int i = P; i < DNAArr.length; i++) {
            int j = i -P;
            rm(DNAArr[j]);
            add(DNAArr[i]);
            if (check == 4) {
                result++;
            }
        }

        System.out.print(result);

    }


}
