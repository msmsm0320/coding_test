import java.io.*;
import java.util.StringTokenizer;

public class RGB거리_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dp[][] = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp[0][0] = Integer.parseInt(st.nextToken());
        dp[0][1] = Integer.parseInt(st.nextToken());
        dp[0][2] = Integer.parseInt(st.nextToken());

        for(int i = 1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
            dp[i][0] = Math.min(dp[i][0] + dp[i-1][1],dp[i][0] + dp[i-1][2]);
            dp[i][1] = Math.min(dp[i][1] + dp[i-1][0],dp[i][1] + dp[i-1][2]);
            dp[i][2] = Math.min(dp[i][2] + dp[i-1][1],dp[i][2] + dp[i-1][0]);
        }
        int result = Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}
