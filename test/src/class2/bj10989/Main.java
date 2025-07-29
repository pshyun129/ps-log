package class2.bj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl+pr) / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;

            if (pl <= pr) {
                int tmp = a[pl];
                a[pl++] = a[pr];
                a[pr--] = tmp;
            }

        } while (pl <= pr);
        if(left < pr) quickSort(a, left, pr);
        if (right > pl) quickSort(a, pl,right);


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, N-1);


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }



    }
}
