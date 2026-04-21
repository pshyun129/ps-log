package swea.mockTest.beatA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class p16236 {
    static int N;
    static int[][] arr;
    static Shark shark;
    static int move;
    static int[] target;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Shark{
        int x;
        int y;
        int size;
        int eat;

        public Shark(int x, int y, int size, int eat) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
        }
    }

    static boolean findTarget(){

        boolean targetUpdate = false;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        q.offer(new int[]{shark.x, shark.y});    // x 좌표, y 좌표, 이동 거리
        visited[shark.x][shark.y] = true;


        int count = 0;
        while (!q.isEmpty()) {
            boolean check = false;
            count++;
            int qsize = q.size();
            for (int i = 0; i < qsize; i++) {
                int[] a = q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = a[0] + dx[d];
                    int ny = a[1] + dy[d];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || arr[nx][ny] > shark.size) continue;
                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 0 || arr[nx][ny] == shark.size) {
                        q.offer(new int[]{nx, ny});

                    } else {
//                        System.out.println("타겟 재설정");

                        targetUpdate = true;
                        check = true;

                        if (target[0] > nx) {
                            target[0] = nx;
                            target[1] = ny;
                        } else if (target[0] == nx) {
                            if (target[1] > ny) {
                                target[0] = nx;
                                target[1] = ny;
                            }
                        }
                    }
                }
            }

            if (check) {
                move+=count;
                break;
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }


        return targetUpdate;
    }

    static void simul(){

        boolean ck = true;




        while (ck) {
            target = new int[]{N, N};

            // 먹을 수 있는 물고기 탐색
            ck = findTarget();
            if (ck) {
                arr[target[0]][target[1]] = 0;
                shark.eat++;
                shark.x = target[0];
                shark.y = target[1];
                if (shark.eat == shark.size) {
                    shark.size++;
                    shark.eat = 0;
                }
            }


        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    arr[i][j] = 0;
                }
            }
        }

        move = 0;

        simul();
        System.out.print(move);


    }
}
