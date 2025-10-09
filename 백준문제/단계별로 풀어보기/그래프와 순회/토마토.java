import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {
    static int arr[][];
    static int date[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        for(int y = 0; y < arr.length; y++){
            for (int x = 0; x < arr[0].length; x++){
                if(arr[y][x] == 1){
                    date[y][x] = 0;
                    q.add(new int[]{y,x});
                }
            }
        }

        while(!q.isEmpty()){
            int cur[] = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= arr[0].length || ny < 0 || ny >= arr.length) continue;
                if(arr[ny][nx] == -1) continue;

                if(date[ny][nx] == -1) {
                    date[ny][nx] = date[cy][cx] + 1;
                    q.add(new int[]{ny,nx});
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

        arr = new int[M][N];
        date= new int[M][N];

        for(int i = 0; i < M; i++){
            Arrays.fill(date[i], -1);
        }

        for(int y = 0; y < M; y++){
            st = new StringTokenizer(br.readLine());
            for(int x = 0; x < N; x++){
                arr[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        int max = 0;
        for(int y = 0; y < M; y++){
            for(int x = 0; x < N; x++){
                if(arr[y][x] == 0 && date[y][x] == -1){
                    bw.write(String.valueOf(-1));
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }
                max = Math.max(date[y][x], max);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
