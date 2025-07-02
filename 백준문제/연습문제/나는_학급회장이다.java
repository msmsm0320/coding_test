import java.io.*;
import java.util.StringTokenizer;

public class 나는_학급회장이다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] candidate = new int[3];
        int[] squared = new int[3];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            candidate[0] += a;
            candidate[1] += b;
            candidate[2] += c;

            squared[0] += a * a;
            squared[1] += b * b;
            squared[2] += c * c;
        }

        int maxScore = Math.max(candidate[0], Math.max(candidate[1], candidate[2]));

        if (countOccurrences(candidate, maxScore) == 1) {
            for (int i = 0; i < candidate.length; i++) {
                if (candidate[i] == maxScore) {
                    bw.write((i + 1) + " " + maxScore + "\n");
                    break;
                }
            }
        } else {
            int maxSquared = Math.max(squared[0], Math.max(squared[1], squared[2]));
            int elected = -1;

            for (int i = 0; i < squared.length; i++) {
                if (squared[i] == maxSquared) {
                    elected = i;
                    break;
                }
            }

            if (countOccurrences(squared, maxSquared) > 1) {
                bw.write("0 " + candidate[elected] + "\n");
            } else {
                bw.write((elected + 1) + " " + candidate[elected] + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int countOccurrences(int[] array, int value) {
        int count = 0;
        for (int v : array) {
            if (v == value) count++;
        }
        return count;
    }
}
