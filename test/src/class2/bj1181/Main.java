package class2.bj1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

/*        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }*/

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        List<String> distinctList = new ArrayList<>(new LinkedHashSet<>(list));

        distinctList.sort(Comparator
                .comparingInt(String::length)          // 1. 길이순 정렬
                .thenComparing(Comparator.naturalOrder()));

/*
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }
*/

        for (String s : distinctList) {
            sb.append(s).append("\n");
        }


        System.out.print(sb);

    }

}
