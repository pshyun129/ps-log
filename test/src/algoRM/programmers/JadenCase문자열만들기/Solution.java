package algoRM.programmers.JadenCase문자열만들기;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static String makeJaden(String s) {
        StringTokenizer st = new StringTokenizer(s);
        ArrayList<String> list = new ArrayList<>();

        // 문자열을 분리하고 string 배열에 넣음
        while (true) {
            list.add(st.nextToken());

            if(!st.hasMoreTokens()) break;
        }

        // 첫글자 검사후 대문자로 변경
        for (int i = 0; i < list.size(); i++) {
            String a = list.get(i);
            a = a.toLowerCase();
            if (a.charAt(0) <= 'z' && a.charAt(0) >= 'a') {
                StringBuilder sb = new StringBuilder(a);
                // 첫글자를 대문자로 변경하고
                sb.setCharAt(0, (char)(a.charAt(0) - 'a' + 'A'));
                // 리스트 값 교체
                list.set(i, sb.toString());
            }
        }


        // 문자열 만들고 리턴
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb2.append(list.get(i));
            if (i < list.size() - 1) {
                sb2.append(" ");
            }
        }

        return sb2.toString();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution("3people unFollowed me"));
        System.out.println(sol.solution("for the last week"));
    }

    public String solution(String s) {
        String answer = "";

        // 알고리즘 구현


        return makeJaden(s);
    }




}