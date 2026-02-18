package swea.mockTest.p2112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2112 {
    static int D, W, K;
    static int[][] arr;
    static int min;



    static void dfs(int cnt, int choice) {
        // 종료 조건
        if (cnt == D) {
            if (check()) {
                min = Math.min(min, choice);
            }

            return;
        }



        //선택이 K개라면 종료
        if (choice >= min) {
            return;
        }

        int[] arr2 = new int[W];

        // 약품 a로 선택했을 경우
        for (int i = 0; i < W; i++) {
            arr2[i] = arr[cnt][i];
        }

        change(cnt, 0);
        dfs(cnt+1, choice+1);

        for (int i = 0; i < W; i++) {
            arr[cnt][i] = arr2[i];
        }

        // 약품 b로 선택했을 경우

        for (int i = 0; i < W; i++) {
            arr2[i] = arr[cnt][i];
        }

        change(cnt, 1);
        dfs(cnt+1, choice+1);

        for (int i = 0; i < W; i++) {
            arr[cnt][i] = arr2[i];
        }

        //선택하지 않았을 경우
        dfs(cnt + 1, choice);


    }

    static void change(int god, int chg) {   //god : 바꿀 행, chg : 바꿀 숫자
        for (int i = 0; i < W; i++) {
            arr[god][i] = chg;
        }
    }


    static boolean check(){     // 충돌 테스트를 통과하는지

        for (int i = 0; i < W; i++) {
            int count = 0;
            int ck = arr[0][i];
            boolean ck2 = false;
            for (int j = 0; j < D; j++) {
                if (arr[j][i] == ck) {
                    count++;
                    ck = arr[j][i];
                }else {
                    count = 1;
                    ck = arr[j][i];
                }
                if (count == K) {
                    ck2 = true;
                    break;
                }
            }
            if(!ck2) return false;
        }
        return true;
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());   // 보호 필름의 두께
            W = Integer.parseInt(st.nextToken());   // 가로 크기
            K = Integer.parseInt(st.nextToken());   // 합격 기준

            arr = new int[D][W];
            //arr2  = new int[W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());   // A : 0, B : 1
                }
            }
            min = K;
            dfs(0, 0);

            System.out.printf("#%d %d\n", test_case, min);

        }


    }

}
