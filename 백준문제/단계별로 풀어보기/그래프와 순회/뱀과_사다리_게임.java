import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과_사다리_게임 {

    public static int N,M;
    public static int[] arr = new int[101];
    public static boolean[] visited = new boolean[101];

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void bfs(int start) throws IOException {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == 100){
                bw.write(String.valueOf(cur[1]));
                bw.flush();
                bw.close();
                return;
            }

            for(int i = 1; i < 7; i++){
                int next = cur[0] + i;
                if(next<=100){
                    if(arr[next]!=0){
                        next = arr[next];
                    }
                    if(!visited[next]){
                        visited[next] = true;
                        q.add(new int[]{next,cur[1]+1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x] = y;
        }

        bfs(1);


        br.close();

    }

}
