package class2.bj10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Member {
        int number;
        int age;
        String name;

        public Member(int number, int age, String name) {
            this.number = number;
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public int getNumber() {
            return number;
        }

        public String getName() {
            return name;
        }
    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    //입력 개수

        List<Member> list = new ArrayList<>();




        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Member(i,Integer.parseInt(st.nextToken()), st.nextToken()));

        }

        list.sort(Comparator.comparing(Member::getAge).thenComparing(Member::getNumber));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).age + " " + list.get(i).name);
        }





    }
}
