package algoRM.programmers.최솟값만들기;

import java.util.Arrays;

public class Solution2 {
    static int min;
    static boolean[] visited;

    public static void main(String[] args) {
        Solution2 sol = new Solution2();

        System.out.println(sol.solution(
                new int[]{1, 4, 2},
                new int[]{5, 4, 4}
        ));

        System.out.println(sol.solution(
                new int[]{1, 2},
                new int[]{3, 4}
        ));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        // 알고리즘 구현

        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[A.length - i - 1];
        }



        return answer;
    }




}