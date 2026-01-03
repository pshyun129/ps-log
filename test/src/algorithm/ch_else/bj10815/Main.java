package algorithm.ch_else.bj10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N]; //상근이 들고 있는 숫자카드

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int result = Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()));
            if (result >= 0) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }

        }
        System.out.println(sb);





    }
}
