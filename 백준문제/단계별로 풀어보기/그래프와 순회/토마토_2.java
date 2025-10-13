import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_2 {
    public static int arr[][][];
    public static int visited[][][];

    public static int[] dx = {0, 0, -1, 1, 0, 0};
    public static int[] dy = {-1, 1, 0, 0, 0, 0};
    public static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < arr[0].length; i++){
            for(int j = 0; j < arr.length; j++){
                for(int k = 0; k < arr[0][0].length; k++){
                    if(arr[j][i][k] == 1){
                        q.add(new int[]{j,i,k});
                        visited[j][i][k] = 0;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 6; i++){
                int nx = cur[1] + dx[i];
                int ny = cur[0] + dy[i];
                int nz = cur[2] + dz[i];

                if(nx < 0 || nx >= arr[0].length || ny < 0 || ny >= arr.length || nz < 0 || nz >= arr[0][0].length) continue;
                if(arr[ny][nx][nz] == -1) continue;
                if(visited[ny][nx][nz] != -1) continue;

                visited[ny][nx][nz] = visited[cur[0]][cur[1]][cur[2]] + 1;
                arr[ny][nx][nz] = 1;

                q.add(new int[]{ny,nx,nz});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());


        arr = new int[N][M][H];
        visited = new int[N][M][H];

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++){
                    arr[j][k][i] = Integer.parseInt(st.nextToken());
                    visited[j][k][i] = -1;
                }
            }
        }

        bfs();

        int result = 0;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(arr[j][k][i] == 0 && visited[j][k][i] == -1){
                        bw.write(String.valueOf(-1));
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                    result = Math.max(result, visited[j][k][i]);
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }
}
