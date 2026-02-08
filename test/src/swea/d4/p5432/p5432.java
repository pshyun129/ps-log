package swea.d4.p5432;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p5432 {


    static int countPieces(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            //막대기가 처음 들어왔을 때의 개수 반영
            if (s.charAt(i) == '(') {
                answer++;
                stack.push('(');
            } else {//초기값은 무조건 '('이므로 i-1 < 0인 상황을 고려할 필요가 없음
                //레이저일때
                if (s.charAt(i - 1) == '(') {
                    stack.pop();
                    answer--;
                    answer += stack.size();
                } else if (s.charAt(i - 1) == ')') {   //막대기의 끝일 때
                    stack.pop();
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String s = br.readLine();
            System.out.printf("#%d %d\n", test_case, countPieces(s));

        }
    }
}
