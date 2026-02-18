package swea.mockTest.p1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1952 {
    static int[] amount;    //이용 금액
    static int[] month;
    static int min;


    static void dfs(int cnt, int mSum) {
        //종료 조건, 12월까지 전부 반영하면 최솟값 반영 후 종료
        if (cnt == 12) {
            if (min > mSum) {
                min = mSum;
            }
            return;
        }

        //계산중인 mSum이 min보다 크면 종료(가지치기)
        if (mSum > min) {
            return;
        }



        //하루권을 선택한 경우
        dfs(cnt+1, mSum + (amount[0] * month[cnt]));

        //한달 이용권을 선택한 경우
        dfs(cnt+1, mSum + amount[1]);

        //3달 이용권을 선택한 경우
        if (cnt + 3 <= 12) {
            dfs(cnt+3, mSum + amount[2]);
        }

        //1년 이용권을 선택한 경우
        if (cnt + 12 == 12) {
            dfs(cnt+12, mSum + amount[3]);
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        amount = new int[4];
        month = new int[12];

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                amount[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            dfs(0, 0);

            System.out.printf("#%d %d\n", test_case, min);

        }


    }


}
