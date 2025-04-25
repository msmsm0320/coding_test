import java.io.*;
import java.util.StringTokenizer;

public class N과_M_2_review {

    public static int com[];
    public static boolean visited[];
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void dfs(int depth, int length, int start,int N) throws IOException{
        if(depth == length){
            StringBuilder sb = new StringBuilder();
            for(int i : com){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
            return;
        }

        for(int i = start; i<=N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            com[depth] = i;
            dfs(depth+1,length,i+1,N);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        com = new int[M];
        visited = new boolean[N+1];


        dfs(0,M,1,N);

        bw.flush();
        bw.close();
        br.close();
    }

}
