package algorithm.ch03.bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int num = 1;

        boolean result = true;

        for (int i = 0; i < arr.length; i++) {
            int su = arr[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                int n = stack.peek();
                if (n != su) {
                    System.out.print("NO");
                    result = false;
                } else {
                    stack.pop();
                    sb.append("-\n");
                }
            }
        }
        if (result) {
            System.out.print(sb);
        }





    }
}
