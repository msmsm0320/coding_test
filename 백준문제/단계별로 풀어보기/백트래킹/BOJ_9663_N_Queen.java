import java.io.*;

public class BOJ_9663_N_Queen {
    static int[] chess;
    static int count;
    static int size;

    public static void dfs(int depth) {
        if (depth == size) {  // 모든 행에 퀸을 배치 완료하면 count 증가
            count++;
            return;
        }

        for (int i = 0; i < size; i++) {  // 가능한 모든 열 탐색
            chess[depth] = i;  // 현재 depth 행의 i 열에 퀸 배치
            if (possible(depth)) {
                dfs(depth + 1);  // 다음 행 탐색
            }
        }
    }

    public static boolean possible(int depth) {
        for (int i = 0; i < depth; i++) {  // 이전 행들과 비교
            if (chess[i] == chess[depth]) return false;  // 같은 열에 있는 경우
            if (Math.abs(i - depth) == Math.abs(chess[i] - chess[depth])) return false;  // 대각선에 있는 경우
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        size = N;
        chess = new int[N];
        count = 0;

        dfs(0);

        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}
