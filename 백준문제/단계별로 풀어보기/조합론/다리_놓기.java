import java.io.*;
import java.util.StringTokenizer;

public class 다리_놓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int dp[][] = new int[30][30];

        for(int i=0; i<30; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int k =2; k<30; k++){
            for(int j =1; j<30; j++){
                dp[k][j] = dp[k-1][j-1] + dp[k-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            sb.append(dp[N][M]).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
