package algorithm.ch03.bj11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> PQ = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB) {
                return a > b ? 1 : -1;
            } else {
                return absA - absB;
            }
        });

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());

            if (A == 0) {
                if (PQ.isEmpty()) {
                    System.out.println(0);

                } else {
                    System.out.println(PQ.poll());
                }
            } else PQ.offer(A);


        }


    }
}
