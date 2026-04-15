package codetree.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class hw01 {
    static int N, M;
    static int[] out;
    static List<Integer> tnstj;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        tnstj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tnstj.add(st.nextToken().charAt(0) - 'a');
        }

        M = Integer.parseInt(br.readLine());
        out = new int[26];

        list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int b = st.nextToken().charAt(0) - 'a';

            list[a].add(b)

        }


    }
}
