import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 구간_합_구하기_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];

        for(int i = 1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<N+1; j++){
                graph[i][j] = graph[i][j-1]+ Integer.parseInt(st.nextToken());
            }
        }


        for(int k = 1; k<=M; k++){
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int l = x1; l<=x2; l++){
                sum += graph[l][y2] - graph[l][y1-1];
            }
            bw.write(String.valueOf(sum) + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
