package swea.d3.p3421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p3421 {
    static int N;
    static int M;
    static List<Integer>[] list;
    static int count;
    static int[] result;


    static void dfs(int cnt){
        //N까지 돌아야 하기 때문에 n보다 크면 종료
        if (cnt > N) {
            //binarySearch를 사용하기 위한 배열 복사 및 정렬
            int[] a = Arrays.copyOf(result, N + 1);
            Arrays.sort(a);
            //부분 집합의 인덱스 별로 같이 있으면 안되는 재료가 결과값에 들어있는 지 검사, 있으면 그냥 리턴, 없으면 count++
            for (int i = 1; i <= N; i++) {
                for (int j : list[result[i]]) {
                    if(result[i] == 0) continue;
                    if (Arrays.binarySearch(a, j) >= 0) {
                        return;
                    }
                }
            }
            count++;
            return;
        }


        //선택한경우
        result[cnt] = cnt;
        dfs(cnt+1);

        //선택 안한경우
        result[cnt] = 0;
        dfs(cnt+1);

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());   //사용할 수 있는 재료의 수
            M = Integer.parseInt(st.nextToken());   //같이 사용이 불가능한 재료 목록 수

            //0일때는 그냥 부분집합의 개수를 구하면 됨
            if (M == 0) {
                System.out.printf("#%d %d\n", test_case, 1 << N);
                continue;
            }


            list = new ArrayList[N + 1];   //같이 사용 불가능한 재료 목록

            for (int i = 0; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            //리스트에 같이 들어가면 안되는 재료 번호를 등록
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            // 부분집합의 최종 결과를 담아둘 배열
            result = new int[N + 1];
            count = 0;

            dfs(1);

            System.out.printf("#%d %d\n", test_case, count);


        }


    }
}
