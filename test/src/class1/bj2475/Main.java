package class1.bj2475;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int a = scanner.nextInt();
            a= a*a;
            sum+=a;

        }
        System.out.println(sum%10);
    }


}
