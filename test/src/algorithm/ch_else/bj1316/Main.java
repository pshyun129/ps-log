package algorithm.ch_else.bj1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int T = Integer.parseInt(br.readLine());    //테스트 케이스 개수
        for (int i = 0; i < T; i++) {

            String s = br.readLine();

            boolean check = true;

            a1 : for (int j = 0; i < s.length(); j++) {
                if (j == s.length() - 1) {
                    continue ;
                }
                for (int k = j+1; k < s.length() ; k++) {

                    if (s.charAt(j) == s.charAt(k)) {
                        if (k - j == 1) {
                            continue a1;
                        } else {
                            check = false;
                            break a1;
                        }
                    }
                }
            }
            if (check) {
                count++;
            }




        }
        System.out.println(count);



    }


}
