package sfSupplement.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char direction = st.nextToken().charAt(0);
            int distance = Integer.parseInt(st.nextToken());

            for (int j = 0; j < distance; j++) {
                switch(direction) {
                    case 'N' :
                        y++;
                        count++;
                        break;
                    case 'S' :
                        y--;
                        count++;
                        break;
                    case 'E' :
                        x++;
                        count++;
                        break;
                    case 'W' :
                        x--;
                        count++;
                        break;
                }
                if (x == 0 && y == 0) {
                    System.out.println(count);
                    return;
                }
            }
        }
        System.out.println(-1);

    }
}
