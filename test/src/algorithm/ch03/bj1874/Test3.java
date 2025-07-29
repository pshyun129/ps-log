package algorithm.ch03.bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Test3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;        //수열 수
        int idx = 0;        //인덱스 번호
        StringBuilder sb = new StringBuilder();

        while (idx < N) {
            if (!stack.isEmpty() && arr[idx] == stack.peek()) {
                stack.pop();
                idx++;
                sb.append("-\n");

            } else if (arr[idx] >= num) {
                stack.push(num++);
                sb.append("+\n");

            } else {
                if (stack.peek() > arr[idx]) {
                    System.out.print("NO");
                    return;
                }
            }
        }
        System.out.print(sb);
    }
}
