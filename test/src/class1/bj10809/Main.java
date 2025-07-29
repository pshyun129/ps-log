package class1.bj10809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int[] arr = new int[26];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = -1;
        }


        for (int i = 0; i < S.length(); i++) {
            char A = S.charAt(i);
            int B = (int)A - 'a';

            if (arr[B] == -1) {
                arr[B] = i;
            }

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }

    }
}
