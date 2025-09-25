import java.io.*;

public class O1타일 {

    public static int dp[];


    public static int fib(int n){


        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2])%15746;
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        dp[0] = 1;
        dp[1] = 1;

        int result = fib(N);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}
