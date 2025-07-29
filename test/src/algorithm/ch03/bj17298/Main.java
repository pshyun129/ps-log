package algorithm.ch03.bj17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 1;
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        stack.push(arr[0]);
        while (idx < N) {
            if (stack.peek() <= arr[idx]) {
                if (num == N) {
                    sb.append(-1 + " ");
                    idx++;
                } else {
                    stack.push(arr[num++]);
                }
            } else if (stack.peek() > arr[idx]) {
                sb.append(stack.peek() + " ");
                idx++;
            }

        }
        System.out.print(sb);



    }
}
