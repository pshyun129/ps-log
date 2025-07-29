package algorithm.ch03.bj11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        StringTokenizer st1 = new StringTokenizer(S);

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        S = br.readLine();      //2번째 줄 읽음
        st1 = new StringTokenizer(S);

        int[] A = new int[N];
        int[] sum = new int[N+1];       //이렇게 하고

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st1.nextToken());
        }
        //합배열
        sum[0] = 0;
        for (int i = 1; i <=N; i++) {       //<= 이렇게 해야 인덱스 번호가 맞아 떨어짐
            sum[i] = sum[i-1] + A[i-1];
        }

        for (int k = 0; k < M; k++) {
            st1 = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st1.nextToken());
            int j = Integer.parseInt(st1.nextToken());
            sb.append(sum[j] - sum[i-1]).append("\n");
        }
        System.out.print(sb);
    }
}
