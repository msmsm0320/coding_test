import java.io.*;

public class 쉬운_계단_수 {

    final static long mod = 1000000000;

    public static long dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp = new long[N+1][10];

        for(int i = 1; i < 10; i++){
            dp[1][i] = 1;
        }

        for(int n = 2; n <= N; n++){
            for(int digit = 0; digit < 10; digit++){
                if(digit > 0) dp[n][digit] += dp[n-1][digit-1];
                if(digit < 9) dp[n][digit] += dp[n-1][digit+1];
                dp[n][digit] %= mod;
            }
        }

        long result = 0;

        for(int i = 0; i < 10; i++){
            result = (result + dp[N][i]) % mod;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
