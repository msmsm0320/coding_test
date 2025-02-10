import java.io.*;

public class BOJ_9663_N_Queen_review {
    static int count; // 퀸을 놓을 수 있는 총 갯수
    static int[] chess; // x번째 행, y번째 열에 퀸이 있음을 표시

    // dfs 접근
    public static void dfs(int depth){
        if(depth == chess.length){ // 모든 행에 퀸을 두면 dfs return
            count++;
            return;
        }
        // 반복문 통해서 depth 행에 여러 열을 둬서 경우의 수 확인
        for(int i = 0; i<chess.length; i++){
            chess[depth] = i;
            if(possible(depth)){ // 해당 depth 행에 i열에 놓은 것이 가능하면 depth+1 로 넘어감
                dfs(depth+1);
            }
        }
    }

    public static boolean possible(int depth){

        for(int i = 0; i<depth; i++){
            if(chess[depth] == chess[i] || Math.abs(depth - i) == Math.abs(chess[depth] - chess[i])) return false;// 이전까지의 행에 같은 열에 퀸이 있는지 확인, 대각선 위치에 퀸이 있는지 확인
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        count = 0;
        chess = new int[N];

        dfs(0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();


    }
}
