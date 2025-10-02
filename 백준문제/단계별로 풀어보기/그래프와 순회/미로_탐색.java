import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] arr;
    public static int[][] visited;

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = 1;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int curx = tmp[0];
            int cury = tmp[1];
            for(int i = 0; i < 4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if(nx < 1 || nx > arr.length-1 || ny < 1 || ny > arr[0].length-1) continue;
                if(arr[nx][ny] < 1) continue;
                if(visited[nx][ny] == 1) continue;

                q.offer(new int[]{nx,ny});
                arr[nx][ny] = arr[curx][cury] + 1;
                visited[nx][ny] = 1;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visited = new int[N+1][M+1];

        for(int i = 1; i <= N; i++){
            String str = br.readLine();
            for(int j = 1; j <= M; j++){
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs(1,1);

        bw.write(String.valueOf(arr[N][M]));
        bw.flush();
        bw.close();
        br.close();
    }

}
