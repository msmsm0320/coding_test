import java.io.*;
import java.util.StringTokenizer;

public class 정수_삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i<N; i++){
            for(int j = 0; j<=i; j++){
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j];
                }
                else{
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        int MAX = Integer.MIN_VALUE;

        for(int i = 0; i<N; i++){
            MAX = Math.max(dp[N-1][i],MAX);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(MAX));
        bw.flush();
        bw.close();
        br.close();
    }
}
