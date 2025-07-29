package algorithm.ch03.bj1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringTokenizer st = new StringTokenizer(S);
        double[] arr = new double[N];

        double M = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
            if (arr[i] > M) {
                M = arr[i];
            }
        }
        double sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]/M*100;

        }
        System.out.print(sum/(double)N);

    }
}
