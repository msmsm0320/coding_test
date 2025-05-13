import java.io.*;
import java.util.StringTokenizer;

public class 스타트와_링크_review {

    public static int MIN = Integer.MAX_VALUE;

    public static boolean player[];
    public static int status[][];

    public static void permute(){
        int start = 0;
        int link = 0;
        for(int i = 0; i<player.length; i++){
            for(int j = i+1; j<player.length; j++){
                if(player[i] && player[j]){
                    start += status[i][j];
                    start += status[j][i];
                }else if(!player[i] && !player[j]){
                    link += status[i][j];
                    link += status[j][i];
                }
            }
        }
        MIN = Math.min(MIN,Math.abs(start - link));
    }

    public static void dfs(int depth, int length){
        if(depth == length){
            permute();
            return;
        }

        for(int i = 0; i<player.length; i++){
            if(player[i]) continue;
            player[i] = true;
            dfs(depth+1,length);
            player[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        player = new boolean[N];
        status = new int[N][N];

        StringTokenizer st;
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,N/2);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(MIN));
        bw.flush();
        bw.close();
        br.close();

    }
}
