package class1.bj3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[42];

        for (int i = 0; i < 10; i++) {

            int A = Integer.parseInt(br.readLine());
            int B = A%42;
            arr[B]++ ;

        }

        int answer = 0;
        for (int i = 0; i < 42; i++) {
            if (arr[i] > 0) {
                answer++;

            }
        }
        System.out.print(answer);
    }
}
