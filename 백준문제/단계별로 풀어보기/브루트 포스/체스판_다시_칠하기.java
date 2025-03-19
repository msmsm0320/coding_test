import java.io.*;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int minPaint = Integer.MAX_VALUE;

        for (int startX = 0; startX <= N - 8; startX++) {
            for (int startY = 0; startY <= M - 8; startY++) {
                // 두 가지 경우의 count (W 시작 / B 시작)
                int countW = 0;
                int countB = 0;

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        // 현재 칸의 색
                        String current = board[startX + i][startY + j];
                        // (i+j) 합이 짝수인 칸과 홀수인 칸의 색이 교차해야 함
                        if ((i + j) % 2 == 0) { // 해당 식에 대해서는 그림 그려서 파악
                            if (!current.equals("W")) countW++;
                            if (!current.equals("B")) countB++;
                        } else {
                            if (!current.equals("B")) countW++;
                            if (!current.equals("W")) countB++;
                        }
                    }
                }

                // 더 작은 값으로 갱신
                minPaint = Math.min(minPaint, Math.min(countW, countB));
            }
        }

        System.out.println(minPaint);
    }
}
