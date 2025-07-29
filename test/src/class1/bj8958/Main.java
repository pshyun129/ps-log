package class1.bj8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());



        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            int add = 0; //가산점

            int sum = 0;

            for (int j = 0; j < a.length(); j++) {
                char b = a.charAt(j);
                if (b == 'O') {
                    sum = sum + 1 + add;
                    add++;

                } else {
                    add = 0;
                }


            }
            System.out.println(sum);

        }



    }
}
