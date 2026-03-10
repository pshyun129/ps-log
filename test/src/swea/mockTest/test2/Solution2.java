package swea.mockTest.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {

    static int N;
    static int[][] arr;
    static List<int[]> core;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] visited;
    //    static boolean[][] mapStatus;
    static int answer;
    static int corecount;
    static int stop;


    static boolean check(int x, int y, int d, boolean[][] mapStatus) {
        if(d == 0) {// 상
            for(int i = x-1; i >= 0; i--) {
                if(mapStatus[i][y] == true) {
                    return false;
                }
            }


        }else if (d == 1) {
            for(int i = x+1; i < N; i++ ) {
                if(mapStatus[i][y] == true) {
                    return false;
                }
            }
        }else if(d == 2) {
            for(int i = y -1; i >= 0; i--) {
                if(mapStatus[x][i] == true) {
                    return false;
                }
            }
        }else if(d == 3) {
            for(int i = y +1; i <N; i++) {
                if(mapStatus[x][i] == true) {
                    return false;
                }
            }
        }

        return true;
    }

    static int count1(int x, int y, int d, boolean[][] mapStatus) {
        int count =0;
        if(d == 0) {// 상
            for(int i = x-1; i >= 0; i--) {
                if(mapStatus[i][y] == false) {
                    count++;
                }
            }


        }else if (d == 1) {
            for(int i = x+1; i < N; i++ ) {
                if(mapStatus[i][y] == false) {
                    count++;
                }
            }
        }else if(d == 2) {
            for(int i = y -1; i >= 0; i--) {
                if(mapStatus[x][i] == false) {
                    count++;
                }
            }
        }else if(d == 3) {
            for(int i = y +1; i <N; i++) {
                if(mapStatus[x][i] == false) {
                    count++;
                }
            }
        }

        return count;
    }


    static boolean[][] makeMap(int x, int y, int d, boolean[][] mapStatus){
        boolean[][] copy = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = mapStatus[i][j];
            }
        }


        if(d == 0) {// 상
            for(int i = x-1; i >= 0; i--) {
                copy[i][y] = true;
            }


        }else if (d == 1) {
            for(int i = x+1; i < N; i++ ) {
                copy[i][y] = true;
            }
        }else if(d == 2) {
            for(int i = y -1; i >= 0; i--) {
                copy[x][i] = true;
            }
        }else if(d == 3) {
            for(int i = y +1; i <N; i++) {
                copy[x][i] = true;
            }
        }


        return copy;
    }


    static void dfs(int count, int lineCount, int coreCount, boolean[][] mapStatus) {
        // 종료 조건
        if(count == core.size()) {



            if(coreCount > corecount) {
                corecount = coreCount;
                answer = lineCount;
            }else if(coreCount == corecount) {
                if(lineCount < answer) {
                    answer = lineCount;
                }
            }

            return;
        }



        int[] a = core.get(count);

        if(a[0] == 0 || a[0] == N-1 || a[1] == 0 || a[1] == N-1) {
            dfs(count + 1, lineCount, coreCount+1, mapStatus);
        }else {
            for(int d = 0; d < 4; d++) {
                if(check(a[0], a[1], d, mapStatus)) {
                    int cnt = count1(a[0], a[1], d, mapStatus);
                    dfs(count + 1, lineCount + cnt, coreCount+1, makeMap(a[0], a[1], d, mapStatus));

                }
            }
        }

        dfs(count+1, lineCount, coreCount, mapStatus);

        // 코어를 선택하고
        // 4방위 탐색
        // 갈수 있으면 맵에 반영후 dfs
        // 갈수 없으면 다음 방위 탐색
        //




    }




    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {

            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            core = new ArrayList<>();

            int ac = 0;
            for(int i = 0; i < N; i++ ) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1) {
                        if(i == 0 || i == N-1 || j == 0 || j == N-1)ac++;
                        core.add(new int[] {i, j});
                    }
                }
            }

            visited = new boolean[core.size()];
            boolean[][] mapStatus = new boolean[N][N];

            // 코어 위치는 미리 true처리
            for(int i = 0; i < core.size(); i++) {
                int[] c = core.get(i);
                mapStatus[c[0]][c[1]] = true;
            }

            stop = core.size() - ac;
            corecount = Integer.MIN_VALUE;
            answer = 0;

            dfs(0, 0, 0, mapStatus);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");




        }
        System.out.print(sb);




    }
}