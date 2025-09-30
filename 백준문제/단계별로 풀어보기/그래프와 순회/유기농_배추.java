import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농_배추 {
    public static int[][] ground;
    public static boolean[][] visited;
    public static int result;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void bfs(int x, int y, int N, int M){
        if(ground[x][y] != 1 || visited[x][y]) return;
        result++;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(ground[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            result = 0;
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            ground = new int[N][M];
            visited = new boolean[N][M];

            for(int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ground[y][x] = 1;
            }

            for(int x = 0; x < N; x++){
                for(int y = 0; y < M; y++){
                    bfs(x, y, N, M);
                }
            }
            sb.append(result).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
