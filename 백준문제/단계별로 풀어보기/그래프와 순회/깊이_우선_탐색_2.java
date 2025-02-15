import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 깊이_우선_탐색_2 {
    static List<Integer>[] graph; // 인접 리스트 방식으로 그래프 저장
    static int[] visitOrder; // 각 정점의 방문 순서 저장
    static int order = 1;
    public static void dfs(int node){
        visitOrder[node] = order++;

        for(int next : graph[node]){
            if(visitOrder[next] == 0){
                dfs(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1]; // 그래프 초기화
        visitOrder = new int[N+1];

        for(int i = 1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // 내림차순 정렬
        for(int i = 1; i<=N; i++){
            graph[i].sort(Collections.reverseOrder());
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=N; i++){
            sb.append(visitOrder[i]).append("\n");
        }
        System.out.println(sb);
    }
}
