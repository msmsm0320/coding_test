import java.io.*;
import java.util.StringTokenizer;

public class N과_M_4_review {

    public static int com[];
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringBuilder sb;

    public static void dfs(int depth, int length, int start, int N) throws IOException {
        if(depth == length){
            sb = new StringBuilder();
            for(int i : com){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }

        for(int i = start; i<=N; i++){
            com[depth] = i;
            dfs(depth+1, length, i, N);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        com = new int[M];

        dfs(0,M,1,N);

        bw.flush();
        bw.close();
        br.close();
    }

}
