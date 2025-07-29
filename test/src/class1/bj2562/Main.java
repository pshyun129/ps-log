package class1.bj2562;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int answer = 0;
        int b= 0;
        for (int i = 1; i <= 9; i++) {
            int a = scanner.nextInt();
            if (a > answer) {
                answer = a;
                b= i;
            }
        }

        System.out.println(answer);
        System.out.println(b);

    }
}
