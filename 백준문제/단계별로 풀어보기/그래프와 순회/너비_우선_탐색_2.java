import java.io.*;
import java.util.*;

public class 너비_우선_탐색_2 {
    static int[] visited;
    static List<Integer>[] graph;
    static int index = 0;

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = ++index;

        while(!q.isEmpty()){
            int point = q.poll();
            for(int i = 0; i<graph[point].size(); i++){
                int next = graph[point].get(i);
                if(visited[next] == 0){
                    visited[next] = ++index;
                    q.offer(next);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new int[N+1];

        for(int i = 0; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int j = 0; j<M; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int k = 1; k<=N; k++){
            Collections.sort(graph[k], Collections.reverseOrder());
        }

        bfs(R);
        for(int l = 1; l<=N; l++){
            bw.write(visited[l] + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
