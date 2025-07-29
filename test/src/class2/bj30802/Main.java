package class2.bj30802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String S = br.readLine();
        String K = br.readLine();
        StringTokenizer st2 = new StringTokenizer(K);

        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());


        int countT= 0;

        StringTokenizer st = new StringTokenizer(S);

        for (int i = 0; i < 6; i++) {

            int a = Integer.parseInt(st.nextToken());

            int b = 0;

            if (a % T == 0) {
                b= a/T;

            } else if (a % T != 0) {
                b = a/T+1;
            }

            countT= countT + b;




        }

        System.out.println(countT);
        System.out.println(N/P + " "  + N%P);
    }
}
