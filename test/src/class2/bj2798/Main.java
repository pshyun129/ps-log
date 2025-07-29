package class2.bj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        StringTokenizer st1 = new StringTokenizer(S);

        int N = Integer.parseInt(st1.nextToken());

        int M = Integer.parseInt((st1.nextToken()));

        String cards = br.readLine();
        st1 = new StringTokenizer(cards);

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st1.nextToken());


        }

        int max = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {


                for (int k = 0; k < arr.length; k++) {

                    if (i == j) {
                        continue;
                    } else if (j == k) {
                        continue;
                    } else if (i == k) {
                        continue;
                    }

                    if (arr[i] + arr[j] + arr[k] > M ) {
                        continue;

                    } else if (arr[i] + arr[j] + arr[k] > max) {
                        max = arr[i] + arr[j] + arr[k];

                    }


                }

            }

        }
        System.out.print(max);



    }
}
