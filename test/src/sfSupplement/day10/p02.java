package sfSupplement.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02 {
    static int N;
    static int[][] arr;
    static int[] result;
    static int min;

    static void dfs(int cnt, int idx) {
        if (cnt == 3) {
            if (check()) {
                int move = makeDist();
                min = Math.min(min, move);
            }

            return;
        }


        for (int i = idx; i <= 9; i++) {
            result[cnt] = i;
            dfs(cnt+1, i+1);


        }

    }

    static boolean check() {
        for (int i = 0; i < 3; i++) {
            if (arr[result[i]][0] == -1) {
                return false;
            }
        }

        return true;
    }

    static int makeDist(){
        int dist = 0;

        dist += Math.abs(arr[10][0] - arr[result[0]][0]) + Math.abs(arr[10][1] - arr[result[0]][1]);

        for (int i = 1; i <= 2; i++) {
            dist += Math.abs(arr[result[i-1]][0] - arr[result[i]][0]) + Math.abs(arr[result[i-1]][1] - arr[result[i]][1]);
        }

        dist += Math.abs(arr[11][0] - arr[result[2]][0]) + Math.abs(arr[11][1] - arr[result[2]][1]);

//        for (int i = 0; i < 3; i++) {
//            System.out.print(result[i] + " ");
//        }
//        if (dist == 4) {
//            System.out.println("here " +dist);
//        }else System.out.println("dist " + dist);

        return dist;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[12][2];       // 1~9 : 동전 위치, 10 : 시작, 11 : 도착

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char a = s.charAt(j);
                if(a == '.'){
                    continue;
                } else if (a == 'S') {
                    arr[10][0] = i;
                    arr[10][1] = j;
                } else if (a == 'E') {
                    arr[11][0] = i;
                    arr[11][1] = j;
                } else {
                    arr[a-'0'][0] = i;
                    arr[a-'0'][1] = j;
                }


            }
        }
        min = 10000000;
        result = new int[3];
        dfs(0, 1);

        if (min == 10000000) {
            System.out.print(-1);
        }else System.out.print(min);

    }

}
