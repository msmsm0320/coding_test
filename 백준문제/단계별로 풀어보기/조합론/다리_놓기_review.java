import java.io.*;
import java.util.StringTokenizer;

public class 다리_놓기_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        int dp[][] = new int[30][30];

        for(int i = 0; i<30; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int j = 2; j<30; j++){
            for(int k = 1; k<30; k++){
                dp[j][k] = dp[j-1][k-1] + dp[j-1][k];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int l = 0; l<T; l++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(dp[M][N]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
