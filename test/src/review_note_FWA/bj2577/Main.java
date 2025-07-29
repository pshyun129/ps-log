package review_note_FWA.bj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N= (Integer.parseInt(br.readLine())) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());



        String S = N + "";

        int[] count = new int[10];


        for (int i = 0; i < S.length(); i++) {



            count[N%10]++;

            N = N/10;

        }
        for (int i = 0; i < count.length; i++) {

            System.out.println(count[i]);
        }



    }
}
