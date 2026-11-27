package algoRM.programmers.최댓값과최솟값;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("1 2 3 4"));
        System.out.println(sol.solution("-1 -2 -3 -4"));
        System.out.println(sol.solution("-1 -1"));
    }

    public String solution(String s) {
        String answer = "";

        // 알고리즘 구현
        StringTokenizer st = new StringTokenizer(s);

        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            list.add(Integer.parseInt(st.nextToken()));
            if(!st.hasMoreTokens()) break;

        }

        Collections.sort(list);

        System.out.print(list.getFirst() + " " + list.getLast());

        return answer;
    }
}