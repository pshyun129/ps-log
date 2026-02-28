package sfSupplement.mock3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class AstudyPr3 {

    static final int[] DX= {0,0,-1,1};
    static final int[] DY= {1,-1,0,0};

    static int size;
    static int[][] mountain;
    static int maxheight = 1;
    static ArrayList<int[]> startPoint = new ArrayList<>();
    static int maxDistance = 0;
    static boolean[][] visited;

    static void move(int x, int y, int dig,int distance) {

        for(int i=0;i<4;i++) {
            int nx=x+DX[i];
            int ny=y+DY[i];

            if(nx<0||ny<0||nx>=size||ny>=size)continue;
            if(visited[ny][nx])continue;
            //목표산이 더 크면
            if(mountain[ny][nx]>=mountain[y][x]) {
                //파야할 횟수
                int diff=mountain[ny][nx]-mountain[y][x]+1;
                if(diff>dig)continue;
                if(mountain[ny][nx]-diff<1)continue;
                mountain[ny][nx]-=diff;
                visited[ny][nx]=true;
                move(nx,ny,dig-diff,distance+1);
                //백 트래킹
                mountain[ny][nx]+=diff;
                visited[ny][nx]=false;
            }
            else {
                visited[ny][nx]=true;
                move(nx,ny,dig,distance+1);
                //백 트래킹
                visited[ny][nx]=false;
            }

        }
        maxDistance=maxDistance>distance?maxDistance:distance;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        int dig = Integer.parseInt(st.nextToken());

        mountain = new int[size][size];

        // 입력과 동시에 가장 높은 봉우리 찾기
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                mountain[i][j] = Integer.parseInt(st.nextToken());
                maxheight = Math.max(maxheight, mountain[i][j]);
            }
        }

        // 가장 높은 산 좌표 저장
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mountain[i][j] == maxheight) {
                    startPoint.add(new int[]{j, i});
                }
            }
        }

        for (int[] sp : startPoint) {
            visited=new boolean[size][size];
            visited[sp[1]][sp[0]]=true;
            move(sp[0], sp[1], dig,1);
        }

        System.out.println(maxDistance);
    }
}
