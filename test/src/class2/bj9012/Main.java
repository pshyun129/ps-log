package class2.bj9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        offer1 : for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int check = 0;
            while (!st.hasMoreTokens()) {

                String s = st.nextToken();


                if (s.equals("(")) {
                    check++;
                } else if (s.equals(")")) {
                    check--;
                }
                if (check < 0) {
                    System.out.println("NO");
                    break offer1;
                }


            }
            if (check == 0) System.out.println("YES");
            else System.out.println("NO");

        }



    }
}
