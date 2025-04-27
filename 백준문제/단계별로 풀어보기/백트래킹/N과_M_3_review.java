import java.io.*;
import java.util.StringTokenizer;

public class N과_M_3_review {


    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int com[];

    public static void dfs(int depth, int length, int N) throws IOException{
        if(depth == length){
            StringBuilder sb = new StringBuilder();

            for(int k : com){
                sb.append(k).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }

        for(int i = 1; i<=N; i++){
            com[depth] = i;
            dfs(depth+1,length,N);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        com = new int[M];

        dfs(0,M,N);

        bw.flush();
        bw.close();
        br.close();
    }

}
