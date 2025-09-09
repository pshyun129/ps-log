package algorithm.ch05.bj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] A;
    static boolean visited[];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];   //기본값이 false래요


        // 각 배열 요소에 ArrayList 생성
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            A[a1].add(a2);
            A[a2].add(a1);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {

            if (visited[i] == false) {
                DFS(i);
                count++;
            }
        }

        System.out.print(count);

    }

    static void DFS(int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j : A[i]) {
            if (visited[j] == false) {
                DFS(j);
            }
        }


    }
}
