package swea.d3.p5215_NSY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Food {

        int score;
        int kcal;

        public Food(int score, int kcal) {
            this.score = score;
            this.kcal = kcal;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setKcal(int kcal) {
            this.kcal = kcal;
        }

        public int getKcal() {
            return kcal;
        }

        public int getScore() {
            return score;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());   //재료 개수
            int L = Integer.parseInt(st.nextToken());   //제한 칼로리

            Food[] food = new Food[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                food[i] = new Food(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            }





        }
    }
}
