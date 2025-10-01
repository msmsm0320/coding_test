import java.io.*;
import java.util.*;

public class DFS와_BFS {
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean visitedDFS[];
    public static boolean visitedBFS[];
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int start){
        visitedDFS[start] = true;
        sb.append(start).append(" ");
        for(int next : graph.get(start)){
            if(!visitedDFS[next]) dfs(next);
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        visitedBFS[start] = true;
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int next : graph.get(cur)){
                if(!visitedBFS[next]){
                    visitedBFS[next] = true;
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
        int V = Integer.parseInt(st.nextToken());

        visitedDFS = new boolean[N+1];
        visitedBFS = new boolean[N+1];

        for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(k).add(l);
            graph.get(l).add(k);
        }

        for(int i = 1; i <= N; i++) Collections.sort(graph.get(i));

        dfs(V);
        sb.append("\n");
        bfs(V);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}