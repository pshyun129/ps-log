package review_note_FWA.bj10951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        StringTokenizer st1;

        String S ;
        while ((S = br.readLine()) !=null){


            st1 = new StringTokenizer(S);

            System.out.println(Integer.parseInt(st1.nextToken())+Integer.parseInt(st1.nextToken()));




        }



    }
}
