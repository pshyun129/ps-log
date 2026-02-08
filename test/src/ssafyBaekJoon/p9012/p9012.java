package ssafyBaekJoon.p9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9012 {

    static void checkVPS(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
        }else System.out.println("NO");


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            checkVPS(s);
        }

    }
}
