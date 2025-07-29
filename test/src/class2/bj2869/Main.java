package class2.bj2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringTokenizer st1 = new StringTokenizer(S);

        int A = Integer.parseInt(st1.nextToken());
        int B = Integer.parseInt(st1.nextToken());
        int V = Integer.parseInt(st1.nextToken());

        int day = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) {
            day++;
        }

        System.out.print(day);


/*
        int distanse = 0;

        for (int i = 0; i < V; i++) {
            distanse += A;
            if (distanse >= V) {
                System.out.print(i);
                break;
            }
            distanse -= B;
            if (distanse >= V) {
                System.out.print(i);
                break;
            }
        }
*/



/*
        int count =0;

        while (true) {
            count++;
            distanse +=A;
            if (distanse >= V) {
                System.out.print(count);
                break;
            }
            distanse -= B;
            if (distanse >= V) {
                System.out.print(count);
                break;
            }


        }*/


    }
}
