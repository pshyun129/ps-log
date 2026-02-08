package swea.d3.p6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p6808 {
    static int[] gyCard;
    static int[] iyCard;
    static int vic;
    static int loss;
    static boolean[] visited;

    static void dfs(int vicCnt, int losCnt, int round) {

        if (round == 9) {
            if (vicCnt > losCnt) {
                vic++;
            } else loss++;
            return;
        }
        int gyC = gyCard[round];

        for (int i = 0; i < 9; i++) {
            //이미 선택한 카드이면 다음 카드
            if(visited[i]) continue;

            //카드 선택
            int iyC = iyCard[i];

            //선택한 카드의 사용 체크
            visited[i] = true;

            if(gyC > iyC){
                dfs(vicCnt + gyC + iyC, losCnt, round + 1);
            }
            else dfs(vicCnt, losCnt + gyC + iyC, round + 1);

            //이번 라운드에서 인영이가 i를 선택했을 때 나올수 있는 경우의 수를 위의 재귀로 모두 탐색했기 때문에
            //다음 카드를 선택하는 경우의 수를 탐색할 때 영향을 주지 않기 위해서 다시 false로 바꾼다
            visited[i] = false;


        }



    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {

            boolean[] check = new boolean[19];
            gyCard = new int[9];  //규영이 카드배열
            iyCard = new int[9];  //인영이 카드배열
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                gyCard[i] = Integer.parseInt(st.nextToken());
                check[gyCard[i]] = true;
            }

            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (check[i] == false) {
                    iyCard[idx++] = i;
                }
            }

            visited = new boolean[9];
            vic = 0;
            loss = 0;

            dfs(0, 0, 0);
            System.out.printf("#%d %d %d\n", test_case, vic, loss);




        }



    }
}
