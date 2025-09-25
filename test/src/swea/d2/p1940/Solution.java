package swea.d2.p1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = Integer.parseInt(br.readLine());    //커멘드 개수
            int speed = 0;
            int distance = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                if (command == 0) {
                    distance += speed;
                    continue;
                }
                int value = Integer.parseInt(st.nextToken());



                if (command == 1) {
                    speed += value;
                    distance += speed;
                } else if (command == 2) {
                    speed -= value;
                    if (speed < 0) {
                        speed = 0;
                    }
                    distance += speed;
                }


            }
            System.out.println("#"+test_case+" "+distance);

        }


    }
}
