package class2.bj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int aa(int a, int b) {
        if (b == 0) {
            return a;
        } else return aa(b, a % b);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringTokenizer st1 = new StringTokenizer(S);
        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());
        int result1 = aa(a, b);
        int result2 = a*b/result1;
        System.out.println(result1);
        System.out.println(result2);
    }
}
