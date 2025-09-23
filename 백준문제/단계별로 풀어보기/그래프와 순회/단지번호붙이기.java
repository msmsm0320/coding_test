import java.io.*;
import java.util.*;

public class 단지번호붙이기 {
    static int graph[][];
    static int visited[][];
    static int N;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static int bfs(int sr, int sc){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        visited[sr][sc] = 1;
        int count = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0; i < 4; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if(visited[nr][nc] == 1) continue;
                if(graph[nr][nc] == 0) continue;
                visited[nr][nc] = 1;
                q.add(new int[]{nr,nc});
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++){
            String v = br.readLine();
            for(int j = 0; j < N; j++){
                graph[i][j] = v.charAt(j) - '0';
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph[i][j] == 1 && visited[i][j] != 1){
                    result.add(bfs(i,j));
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        for(int i = 0; i < result.size(); i++){
            sb.append(result.get(i)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
