import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649_N과_M_1_review {

    static int permute[];
    static boolean visited[];

    public static void dfs(int depth, int length){
        if(depth == length){
            for(int k : permute){
                System.out.print(k + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<visited.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            permute[depth] =i;
            dfs(depth+1,length);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        permute = new int[M];

        dfs(0,M);

        br.close();
    }
}
