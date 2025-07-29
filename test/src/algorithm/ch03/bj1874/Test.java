package algorithm.ch03.bj1874;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1; // 다음에 push할 숫자
        int idx = 0; // arr에서 현재 비교할 인덱스

        while (idx < N) {
            if (!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                sb.append("-\n");
                idx++;
            } else if (num <= N) {
                stack.push(num++);
                sb.append("+\n");
            } else {
                // 더 이상 push할 숫자가 없고, 원하는 숫자도 stack에 없음
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb);
    }
}
