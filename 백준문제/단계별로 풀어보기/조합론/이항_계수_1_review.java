import java.io.*;
import java.util.StringTokenizer;

public class 이항_계수_1_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dp[][] = new int[10][10];

        for(int i = 0; i<10; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        for(int j = 2; j<10; j++){
            for(int k = 1; k<10; k++){
                dp[j][k] = dp[j-1][k-1] + dp[j-1][k];
            }
        }
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(dp[N][K]));
        bw.flush();
        bw.close();
        br.close();
    }
}
