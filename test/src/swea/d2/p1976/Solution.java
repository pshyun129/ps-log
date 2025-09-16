package swea.d2.p1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());   //1 시간
            int b = Integer.parseInt(st.nextToken());   //1 분
            int c = Integer.parseInt(st.nextToken());   //2 시간
            int d = Integer.parseInt(st.nextToken());   //2 분

            int resultT = 0;
            int resutlM = 0;

            if (a + c > 12) {
                resultT = a + c - 12;
            }else resultT = a+c;

            if (b + d > 59) {
                resultT++;
                resutlM = b+d -60;
            }else resutlM = b+d;

            System.out.println("#"+(i+1)+" "+resultT+" "+resutlM);


        }



    }



}
