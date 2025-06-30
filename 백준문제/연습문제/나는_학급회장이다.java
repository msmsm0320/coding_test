import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나는_학급회장이다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[4];
        int[] count3 = new int[4];
        int[] count2 = new int[4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                int s = Integer.parseInt(st.nextToken());
                score[j] += s;
                if (s == 3) count3[j]++;
                else if (s == 2) count2[j]++;
            }
        }

        int maxScore = Math.max(score[1], Math.max(score[2], score[3]));

        int tieCount = 0;
        int winner = 0;

        for (int i = 1; i <= 3; i++) {
            if (score[i] == maxScore) {
                tieCount++;
                if (winner == 0) winner = i;
                else {
                    if (count3[i] > count3[winner]) {
                        winner = i;
                    } else if (count3[i] == count3[winner]) {
                        if (count2[i] > count2[winner]) {
                            winner = i;
                        } else if (count2[i] == count2[winner]) {
                            winner = 0;
                        }
                    }
                }
            }
        }

        System.out.println(winner + " " + maxScore);
    }
}
