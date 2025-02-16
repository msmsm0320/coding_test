import java.io.*;
import java.util.*;

public class 깊이_우선_탐색_2_review {
    static List<Integer>[] graph; // 인접 리스트 배열 초기화
    static int[] visited; // 현재 방문 위치(+방문 여부 판단, 해당 인덱스가 0보다 크면 방문 O, 0이면 방문 X)
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 현재 방문 위치 배열, 인접 리스트 배열 생성
        visited = new int[N+1];
        graph = new ArrayList[N+1];

        // 인접 리스트 배열 초기화
        for(int l = 0; l<=N; l++){
            graph[l] = new ArrayList<>();
        }

        // 인접 리스트 배열 정보 삽입
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 각 리스트마다 내림차순 정렬
        for(int n = 1; n<=N; n++){
            Collections.sort(graph[n], Collections.reverseOrder());
        }

        dfs(R);

        for(int j = 1; j<=N; j++){
            bw.write(visited[j] + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        visited[start] = ++index;
        for(int k : graph[start]){
            if(visited[k] == 0){
                dfs(k);
            }
        }
    }
}
