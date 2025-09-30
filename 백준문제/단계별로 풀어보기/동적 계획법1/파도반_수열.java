import java.io.*;

public class 파도반_수열 {
    public static long dp[] = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i < 101; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        for(int i = 0; i < T; i++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
