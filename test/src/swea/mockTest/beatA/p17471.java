package swea.mockTest.beatA;
/*
그래프를 만들고
부분집합으로 선거구를 뽑음(dfs) -> N이 10보다 작음
뽑은 선거끼리 이어져 있는지 검사(bfs)
각 선거구가 이어져 있다면 최솟값을 구함

최솟값을 구할 때 0이면 즉시 종료


 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p17471 {
    static int N;
    static int[] peopleCount;
    static List<Integer>[] list;
    static boolean[] check;     // true가 red(뽑은거)
    static boolean[] red, blue;
    static int min;

    static boolean bfs(List<Integer> li, boolean t) {
        Queue<Integer> q = new ArrayDeque<>();

        boolean[] visited = new boolean[N + 1];

        q.offer(li.get(0));
        visited[li.get(0)] = true;

        while (!q.isEmpty()) {

            int a = q.poll();

            for (int i : list[a]) {
                if(check[i] != t) continue;
                if(visited[i]) continue;
                visited[i] = true;
                q.offer(i);

            }


        }

        for (int i = 0; i < li.size(); i++) {
            if(!visited[li.get(i)])return false;
        }
        return true;
    }


    static boolean ck(){
        List<Integer> red = new ArrayList<>();
        List<Integer> blue = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                red.add(i);
            } else blue.add(i);
        }

        if (!bfs(red, true)) {
            return false;
        }
        if (!bfs(blue, false)) {
            return false;
        }

        return true;
    }

    static int getP(boolean t) {
        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (check[i] == t) {
                sum += peopleCount[i];
            }
        }

        return sum;
    }

    static boolean getAns;
    static void dfs(int cnt, int pick){     // cnt -> 0으로 시작, pick : 현재까지 선택한 선거구 개수
        if(getAns) return;

        // 종료 조건
        if (cnt == N+1) {
            // 한쪽으로 몰린게 아니라면
            if (pick != 0 && pick != N) {
                if (ck()) {
                    int a = Math.abs(getP(true) - getP(false));
                    min = Math.min(a, min);
                    if (min == 0) {
                        getAns = true;
                    }
                }

            }

            return;
        }



        // 현재 선거구를 선택하는 경우
        check[cnt] = true;
        dfs(cnt + 1, pick + 1);

        // 현재 선거구를 선택하지 않는 경우
        check[cnt] = false;
        dfs(cnt + 1, pick);
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        peopleCount = new int[N + 1];    // 인구수 배열

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            peopleCount[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        red = new boolean[N + 1];
        blue = new boolean[N + 1];

        min = Integer.MAX_VALUE;
        getAns = false;
        check = new boolean[N + 1];

        dfs(1, 0);

        if (min == Integer.MAX_VALUE) {
            System.out.print((-1));

        } else {
            System.out.print(min);
        }

    }
}
