package class1.bj2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());



        int a = 0;
        while (a<T) {
            String n = br.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(n, " ");
            int R = Integer.parseInt(stringTokenizer.nextToken());
            String S = stringTokenizer.nextToken();

            String[] arr = S.split("");
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < R; j++) {
                    System.out.print(arr[i]);
                }

            }
            System.out.print("\n");
            a++;

        }


    }
}
