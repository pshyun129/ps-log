package ssafyBaekJoon.p17952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class p17952 {
    static int N;



    static int findScore(BufferedReader br)throws IOException{
        int answer = 0;

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) - 1;

                //수행시간이 1인 경우 처리
                if (time == 0) {
                    answer+=score;
                    continue;
                }
                stack.push(new int[] {score, time});
            }else {
                if (stack.isEmpty()) continue;
                int[] arr = stack.pop();
                arr[1]--;

                //시간이 0이면 점수 반영후 삭제
                if (arr[1] == 0) {
                    answer += arr[0];
                }else {
                    stack.push(arr);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int result = findScore(br);

        System.out.println(result);


    }
}
