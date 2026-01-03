package swea.d4.p1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] map;
    static int result;
    static int x;
    static int y;

    static void found() {


        while (x != 1) {

            if (y+1 <= 100 && map[x][y + 1] == 1) {
                //y = y+1;
                while (y+1 <= 100 && map[x][y + 1] != 0) {
                    y = y+1;

                }
                x = x-1;
                continue;

            }



            if (y-1 >= 1 && map[x][y - 1] == 1) {
                //y = y -1;
                while (y-1 >= 1 && map[x][y - 1] != 0) {
                    y = y-1;

                }
                x = x-1;
                continue;


            }

            x = x-1;



        }





    }





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= 10; test_case++) {

            int T = Integer.parseInt(br.readLine());

            map = new int[101][101];




            for (int i = 1; i <= 100; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }
            }

            //System.out.println(x + " "+ y);

            found();

            System.out.println("#"+test_case+" "+(y-1));    //0 base로 변환




        }

    }
}
