package sfSupplement.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int x = 0;
        int y = 0;
        int[] dx = {0, 1, 0, -1};   //북 동 남 서
        int[] dy = {1, 0, -1, 0};
        int d = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == 'F') {
                x += dx[d];
                y += dy[d];
                count++;

                if (x == 0 && y == 0) {
                    System.out.println(count);
                    return;
                }
            } else if (a == 'R') {
                if (d == 3) {
                    d = 0;
                } else d++;
                count++;
            } else {
                if (d == 0) {
                    d = 3;
                }else d--;
            }
        }
        System.out.println(-1);


    }
}
