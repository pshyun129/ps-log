package class1.bj11720;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        String x = scanner.next();



        int sum = 0;
        for (int i = 0; i < a; i++) {
            char b = x.charAt(i);
            int c =b-'0';

            sum+=c;

        }


        System.out.println(sum);
    }
}
