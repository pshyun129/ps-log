package class2.bj1246;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String S = br.readLine();

        double sum = 0;
        int max = 0;

        StringTokenizer st = new StringTokenizer(S);

        for (int i = 0; i < N; i++) {

            int a = Integer.parseInt((st.nextToken()));
            if (max < a) {
                max= a;
            }
        }


        st = new StringTokenizer(S);

        for (int i = 0; i < N; i++) {

            double b = (double)(Integer.parseInt(st.nextToken()));
            sum += b/((double)max)*100.0;


        }

        System.out.print(sum / ((double) N));




    }
}
