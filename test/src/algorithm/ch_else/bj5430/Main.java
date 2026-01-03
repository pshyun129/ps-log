package algorithm.ch_else.bj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        a1 : for (int i = 0; i < T; i++) {

            String S = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String X = br.readLine();

            List<Integer> list = new LinkedList<>();

            for(int j = 0; j < X.length(); j++){

                if (X.charAt(j) != '[' && X.charAt(j) != ',' && X.charAt(j) != ']') {

                    int a = X.charAt(j) - '0';
                    list.add(a);

                }

            }


            boolean reverse = true; //안뒤집힌 상태
            for (int j = 0; j < S.length(); j++) {

                char fun = S.charAt(j);

                if (fun == 'R') {
                    reverse = !reverse;
                }

                if (fun == 'D') {
                    if (list.isEmpty()) {
                        System.out.println("error");
                        continue a1;
                    }
                    if (reverse) {
                        list.remove(0);

                    } else {
                        list.remove(list.size() - 1);



                    }


                }



            }
            if (list.isEmpty()) {
                System.out.println("error");
                continue a1;
            }


            StringBuilder sb = new StringBuilder();
            sb.append("[");

            if (reverse) {
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));
                    if (j != list.size() - 1) {
                        sb.append(",");
                    }

                }
            } else {
                for (int j = list.size()-1; j >= 0; j--) {
                    sb.append(list.get(j));
                    if (j != 0) {
                        sb.append(",");
                    }

                }
            }



            sb.append("]");
            System.out.println(sb);






        }


    }
}
