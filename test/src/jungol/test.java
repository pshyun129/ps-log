package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test {
    static int N;
    static int length; // 총 판자의 길이
    static int[] arr;
    static int result;


    static boolean checkLength(int idx){
        return arr[idx] > length;
    }


    static void getAnswer() {

        while (N > 0) {
            // N-1번째 길이보다 긴지 검사
            if(N != 1){
                result += length;   // 비용 반영
                length -= arr[N-1]; // 자르기 반영

            }
            N--;
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        length = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            length += arr[i];
        }

        Arrays.sort(arr);

        result = 0;
        getAnswer();
        System.out.print(result);


    }

}
