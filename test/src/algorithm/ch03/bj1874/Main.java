package algorithm.ch03.bj1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        for (int i = 1; i <=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();


        int i = 1;
        int j = 1;
        int count = 0;
        //stack.push(j);
        while (j <= N) {
            if (arr[i] >= j) {
                stack.push(j);
                sb.append("+").append("\n");
            }
            if (arr[i] == j) {
                stack.pop();
                sb.append("-").append("\n");
                i++;
                count++;
            }

            j++;

        }
        for (int k = stack.size(); k >= 1; k--) {
            if (arr[i] == stack.peek()) {
                stack.pop();
                sb.append("-").append("\n");
                i++;
                count++;
            } else {
                stack.pop();
                sb.append("-").append("\n");
                i++;
            }
        }
        if (N == count) {
            System.out.print(sb);

        } else {
            System.out.print("NO");
        }




/*        for (int i = 1; i <= N; i++) {
            if (arr[i] < i) {
                stack.push(i);
                sb.append("+").append("\n");
            } else if (arr[i] == i) {
                stack.pop();
            }


        }*/


    }
}
