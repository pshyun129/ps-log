package swea.d4.p1486;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
    static int[] arr;
    //static boolean[] visited;
    static int N;
    static int B;
    static int answer;

    static void findH(boolean choose, int sum, int idx) {

        //목표 조기 달성시 종료조건
        if (sum >= B) {
            if (sum < answer) {
                answer = sum;
            }
            return;
        }

        //모든 인덱스 검사 후 종료조건
        if (idx > N) return;


        //선택했을경우
        if (choose == true) {
            sum += arr[idx];
        }

        //선택한경우
        findH(true, sum, idx+1);

        //선택 안한 경우
        findH(false, sum, idx+1);




    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N+1];
            //visited = new boolean[N];
            st = new StringTokenizer(br.readLine());



            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            answer = Integer.MAX_VALUE;

            findH(false, 0, 0);

            /*System.out.println(B);
            System.out.println(answer);*/
            System.out.println("#"+test_case+" "+(answer - B));


        }



    }
}
