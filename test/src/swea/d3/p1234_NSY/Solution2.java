package swea.d3.p1234_NSY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {

    static List<Integer> list;

    static void makePw() {
        boolean check = true;

        while (check == true) {
            check = false;
            for (int i = 0; i < list.size() -1; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    list.remove(i + 1);
                    list.remove(i);
                    check = true;
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            String s = st.nextToken();

            list = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                list.add(s.charAt(i) - '0');
            }


            makePw();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));

            }
            System.out.println("#"+test_case+" "+sb);






        }

    }



}
