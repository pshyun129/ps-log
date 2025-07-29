package class2.bj2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        int[][] arr = new int[15][15];
        for (int i = 0; i < 15; i++) {
            arr[0][i] = i;
            arr[i][0] = 1;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 1; i < 15; j++) {
                int sum = 0 ;

                for (int k = 0; k < 15; k++) {


                    
                }



            }


        }



        for (int i = 0; i < T; i++) {

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());





        }


    }





}
