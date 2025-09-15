package swea.d2.p1983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {



    public static class Student implements Comparable<Student> {
        int number;
        double score;

        public void setNumber(int number) {
            this.number = number;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public Student(int number, double score) {
            this.number = number;
            this.score = score;
        }

        public int getNumber() {
            return number;
        }
        public double getScore() {
            return score;
        }

        @Override
        public int compareTo(Student other) {
            return Double.compare(other.score, this.score); // 내림차순?
        }


    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   //학생수
            int K = Integer.parseInt(st.nextToken());   //학생 번호
            Student[] students = new Student[N];

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                double a = Double.parseDouble(st.nextToken());  //중간고사
                double b = Double.parseDouble(st.nextToken());  //기말고사
                double c = Double.parseDouble(st.nextToken());  //과제
                double result = ((a * 35.0) / 100) + ((b * 45.0) / 100) + ((c * 20) / 100);
                students[j] = new Student(j+1, result);


            }
            Arrays.sort(students);

            String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

            int idx = -1;
            for (int j = 0; j < N; j++) {
                if (students[j].getNumber() == K) {
                    idx = j;
                    break;
                }
            }

            int result = (idx * 10) / N;
            System.out.println("#"+(i+1)+" "+grades[result]);


        }
    }
}
