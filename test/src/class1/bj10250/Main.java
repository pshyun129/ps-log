package class1.bj10250;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); //테스트 데이터

        for (int i = 0; i < T; i++) {
            int H = scanner.nextInt();
            int W = scanner.nextInt();
            int N = scanner.nextInt();
/*
            int x = N%H;
            int y = N/H+1;*/

            if (N % H == 0) {
                System.out.println(H * 100 + N / H);
            } else {
                System.out.println(N % H * 100 + N / H + 1);
            }

        }
    }
}
