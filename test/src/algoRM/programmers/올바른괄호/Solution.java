package algoRM.programmers.올바른괄호;

import java.util.ArrayDeque;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("()()"));
        System.out.println(sol.solution("(())()"));
        System.out.println(sol.solution(")()("));
        System.out.println(sol.solution("(()("));
    }

    boolean solution(String s) {
        boolean answer = true;

        // 여기에 알고리즘 구현

        // 만약 올바른 괄호가 아니면 false
        if (!check(s)) {
            answer = false;
        }


        return answer;
    }

    // 올바른 괄호 검사
    boolean check(String s) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int length = s.length();

        for (int i = 0; i < length; i++) {
            char a = s.charAt(i);
            if (a == '(') {
                stack.push(1);

            } else {
                // 만약 스택이 비어있다면 false후 종료
                if (stack.isEmpty()) {
                    return false;
                }
                // 아니면 pop
                stack.pop();
            }
        }

        // 검사후 stack이 남아 있으면 false
        if(!stack.isEmpty()) return false;

        return true;
    }


}