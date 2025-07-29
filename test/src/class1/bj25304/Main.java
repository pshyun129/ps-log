package class1.bj25304;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();

        int N = scanner.nextInt();

        int c =0;
        int d =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                c = a + b;
            }
            d = d+c;
        }

        if (d == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
