import java.io.*;
import java.util.*;

public class 바이러스 {
    static int[] visited;
    static int[][] graph;

    public static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;

        while(!q.isEmpty()){
            int n = q.poll();

            for(int i = 1; i < graph.length; i++){
                if(visited[i] == 0 && graph[n][i] == 1){
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new int[N+1];
        graph = new int[N+1][N+1];

        StringTokenizer st;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[k][l] = 1;
            graph[l][k] = 1;
        }

        bfs(1);

        int count = 0;
        for(int i = 2; i < N+1; i++){
            if(visited[i] == 1) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

}