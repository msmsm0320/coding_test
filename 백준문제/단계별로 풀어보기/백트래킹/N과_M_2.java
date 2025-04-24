import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N과_M_2 {

    static int[] permute;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void backTracking(int start, int depth, int N, int M) throws IOException{
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i : permute) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;

        }
        for(int i = start; i<=N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            permute[depth] = i;
            backTracking(i+1,depth+1,N,M);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        permute = new int[M];
        visited = new boolean[N + 1];

        backTracking(1,0,N,M);

        bw.flush();
        bw.close();
        br.close();

    }

}
