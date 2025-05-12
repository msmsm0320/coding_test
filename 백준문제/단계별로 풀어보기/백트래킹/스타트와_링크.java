import java.io.*;
import java.util.StringTokenizer;

public class 스타트와_링크 {

    public static int status[][];
    public static boolean player[];
    public static int Min = Integer.MAX_VALUE;

    public static int permute(){
        int startSum = 0;
        int linkSum = 0;
        for(int i = 0; i<player.length-1; i++){
            for(int j = i+1; j<player.length; j++){
                if(player[i] && player[j]){
                    startSum += status[i][j];
                    startSum += status[j][i];
                }
                else if(!player[i] && !player[j]){
                    linkSum += status[i][j];
                    linkSum += status[j][i];
                }
            }
        }
        return Math.abs(startSum - linkSum);
    }

    public static void dfs(int depth, int length, int index){
        if(depth == length){
            int result = permute();
            Min = Math.min(result,Min);
            return;
        }

        for(int i =index; i<player.length; i++){
            if(player[i]) continue;
            player[i] = true;
            dfs(depth+1,length,i + 1);
            player[i] = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        player = new boolean[N];
        status = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,N/2, 0);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(Min));
        bw.flush();
        bw.close();
        br.close();


    }
}
