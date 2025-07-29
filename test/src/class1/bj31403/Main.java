package class1.bj31403;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();


        String d = Integer.toString(A);
        String e = Integer.toString(B);

        int combined = Integer.parseInt(d + e);


        System.out.println(A+B-C);
        System.out.println(combined-C);
    }
}
