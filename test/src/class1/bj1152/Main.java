package class1.bj1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String N = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(N);
        System.out.println(stringTokenizer.countTokens());

    }
}
