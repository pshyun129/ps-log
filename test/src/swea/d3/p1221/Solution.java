package swea.d3.p1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            st = new StringTokenizer(br.readLine());

            String S = st.nextToken();

            int N = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int[] check = new int[10];

            for (int i = 0; i < N; i++) {

                String S2 = st.nextToken();

                switch (S2) {
                    case "ZRO":
                        check[0]++;
                        break;
                    case "ONE":
                        check[1]++;
                        break;
                    case "TWO":
                        check[2]++;
                        break;
                    case "THR":
                        check[3]++;
                        break;
                    case "FOR":
                        check[4]++;
                        break;
                    case "FIV":
                        check[5]++;
                        break;
                    case "SIX":
                        check[6]++;
                        break;
                    case "SVN":
                        check[7]++;
                        break;
                    case "EGT":
                        check[8]++;
                        break;
                    case "NIN":
                        check[9]++;
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < check[i]; j++) {
                    switch (i) {
                        case 0:
                            sb.append("ZRO ");
                            break;
                        case 1:
                            sb.append("ONE ");
                            break;
                        case 2:
                            sb.append("TWO ");
                            break;
                        case 3:
                            sb.append("THR ");
                            break;
                        case 4:
                            sb.append("FOR ");
                            break;
                        case 5:
                            sb.append("FIV ");
                            break;
                        case 6:
                            sb.append("SIX ");
                            break;
                        case 7:
                            sb.append("SVN ");
                            break;
                        case 8:
                            sb.append("EGT ");
                            break;
                        case 9:
                            sb.append("NIN ");
                            break;
                    }
                }
            }
            System.out.println("#"+test_case+"\n"+sb);



        }

    }
}
