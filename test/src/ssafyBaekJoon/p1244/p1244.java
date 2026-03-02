package ssafyBaekJoon.p1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1244 {
    static int N;   // 스위치 개수
    static int M;   // 학생 수
    static int[] arr;


    static void change(int idx){
        if (arr[idx] == 1) {
            arr[idx] = 0;
        }else arr[idx] = 1;
    }


    static void male(int num) {     // 스위치 번호가 num의 배수이면 스위치의 상태를 바꾼다
        for (int i = num; i <= N; i += num) {
            change(i-1);
        }
    }

    static void female(int num) {   // num 중심으로 양쪽 비교, 같은 값인 만큼 변경
        int pl = num - 1;   // 0-based 반영
        int pr = num - 1;

        boolean check = false;

        do {
            pl--;
            pr++;
            if(pl < 0 || pr >= N) break;
            check = false;
            if (arr[pl] == arr[pr]) {
                check = true;
            }

        }while (check);

        for (int i = pl + 1; i < pr; i++) {
            change(i);
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {  // 남자
                male(num);

            }else{  // 여자
                female(num);
            }


        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i != 0 && i % 20 == 0) {
                sb.append("\n").append(arr[i]).append(" ");
                continue;
            }
            sb.append(arr[i]).append(" ");
        }

        System.out.print(sb);
    }
}
