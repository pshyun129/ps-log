package sfSupplement.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p01 {
    static int K, N;
    static StringBuilder sb = new StringBuilder();
    static int[] result;

    static void dfs(int cnt, int bfPick, int sameCnt) {
        // 종료 조건
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");


            return;
        }

        if (N == 1) {
            for (int i = 1; i <= K; i++) {
                sb.append(i).append("\n");
            }

            return;
        }




        for (int i = 1; i <= K; i++) {
            if (i == bfPick) {
                result[cnt] = i;
                if(sameCnt+1 >= 2) continue;
                dfs(cnt+1, i, sameCnt+1);
            }else {
                result[cnt] = i;
                dfs(cnt+1, i, 0);
            }
        }
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());   // 숫자 범위
        N = Integer.parseInt(st.nextToken());   // 뽑는 횟수
        result = new int[N];

        dfs(0, 0, 0);
        System.out.println(sb);

    }

}
