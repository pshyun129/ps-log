package class2.bj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringTokenizer st = new StringTokenizer(S);



        int count = 0;

        for (int i = 0; i < N; i++) {

            int a = Integer.parseInt(st.nextToken());

            int b = 2;
            int t = 2;

            if (a <= 1) {
                continue;
            }


            while (b != a ) {
                if (a % b == 0) {
                    break;
                } else {
                    t++;
                }
                b++;
            }


            if (a == t) {
                count++;
            }

        }


        System.out.println(count);

    }
}
