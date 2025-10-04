import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의_이동 {
    static int[][] visited;

    static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};

    public static void bfs(int startX, int startY, int targetX, int targetY){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX,startY});

        visited[startX][startY] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i < 8; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || nx > visited.length-1 || ny < 0 || ny > visited[0].length-1) continue;
                if(visited[nx][ny] > 0) continue;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            int l = Integer.parseInt(br.readLine());
            visited = new int[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int target[] = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            bfs(cur[0],cur[1],target[0],target[1]);
            sb.append(visited[target[0]][target[1]]-1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
