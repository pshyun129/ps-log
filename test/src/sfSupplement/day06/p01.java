package sfSupplement.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class p01 {
    static int N, r, c;
    static int[][] arr;
    static boolean move;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] max = new int[4];
    static List<Integer> list = new ArrayList<>();


    static void findMax(){
        offer : while(move){

            for (int d = 0; d < 4; d++) {
                int nx = r + dx[d];
                int ny = c + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                    max[d] = 0;
                    continue;
                }

                max[d] = arr[nx][ny];
            }

            for (int i = 0; i < 4; i++) {
                if (max[i] > arr[r][c]) {
                    r += dx[i];
                    c += dy[i];
                    list.add(arr[r][c]);
                    continue offer;
                }
            }
            move = false;

        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()) -1;
        c = Integer.parseInt(st.nextToken()) -1;

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move = true;
        list.add(arr[r][c]);
        findMax();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }


        System.out.print(sb);



    }
}
