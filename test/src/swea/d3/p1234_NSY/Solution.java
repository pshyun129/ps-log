package swea.d3.p1234_NSY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String S = st.nextToken();

            List<Character> list = new ArrayList<>();

            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < S.length(); i++) {
                list.add(S.charAt(i));
            }

            boolean check = false;
            while (check) {
                for (int i = 1; i < list.size(); i--) {
                    if ((list.get(i - 1)).equals(list.get(i))) {


                    }


                }


            }



        }

    }
}
