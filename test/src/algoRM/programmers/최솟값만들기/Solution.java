package algoRM.programmers.최솟값만들기;

public class Solution {
    static int[] arrA;
    static int[] arrB;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) {
        Solution sol = new Solution();

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
        arrA = A;
        arrB = B;

        visited = new boolean[arrA.length];
        min = Integer.MAX_VALUE;
        // 알고리즘 구현
        dfs(0, 0);

        return min ;
    }

    void dfs(int idx, int sum) {
        // 마지막꺼까지 하면 정지
        if (idx == arrA.length) {
            System.out.println("마지막" + "idx : " + idx + ", sum : " + sum);
            min = Math.min(min, sum);
            return;
        }
        // 가지치기, sum이 현재 min보다 크면 종료
        if (sum >= min) return;

        for (int i = 0; i < arrA.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            // B 배열만큼 반복
//            System.out.print(i + "번째 B배열");
            int a = arrA[idx] * arrB[i];
            dfs(idx + 1, sum + a);
            visited[i] = false;

        }

    }



}