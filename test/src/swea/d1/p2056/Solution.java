package swea.d1.p2056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String a = br.readLine();

            String year = a.substring(0,4);
            String month = a.substring(4, 6);
            String day = a.substring(6, 8);

            int year2 = Integer.parseInt(year);
            int month2 = Integer.parseInt(month);
            int day2 = Integer.parseInt(day);

            if (month2 < 1 || month2 > 12) {
                System.out.println("#" + (i + 1) + " -1");
                continue;
            }
            switch(month2) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (day2 < 1 || day2 > 31) {
                        System.out.println("#" + (i + 1) + " -1");
                    } else System.out.println("#" + (i + 1) + " " + year + "/" + month + "/" + day);
                    break;
                case 4: case 6: case 9: case 11:
                    if (day2 < 1 || day2 > 30) {
                        System.out.println("#" + (i + 1) + " -1");
                    } else System.out.println("#" + (i + 1) + " " + year + "/" + month + "/" + day);
                    break;
                case 2 :
                    if (day2 < 1 || day2 > 28) {
                        System.out.println("#" + (i + 1) + " -1");
                    } else System.out.println("#" + (i + 1) + " " + year + "/" + month + "/" + day);
                    break;
            }


        }



    }
}
