import java.io.*;

public class 알고리즘_수업_피보나치_수_1_reivew {

    public static int code1 = 0;
    public static int code2 = 0;

    public static int fib(int n){
        if ( n == 1 || n == 2 ){
            code1++;
            return 1;
        }
        return fib(n-1) + fib(n - 2);
    }

    public static int fibonacci(int n){
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i<n; i++){
            code2++;
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        fib(N);
        fibonacci(N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(code1 + " " + code2);
        bw.flush();
        bw.close();
        br.close();
    }
}
