package algorithm.ch_else.bj1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int count = 0;
        String t;
        while (st.hasMoreTokens()) {
            t = st.nextToken();
            count++;



        }


        System.out.println(count);

    }
}
