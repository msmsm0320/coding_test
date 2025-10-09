import java.io.*;

public class 포도주_시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n+1];
        int dp[] = new int[n+1];

        for(int i = 1; i < n+1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if(n > 1){
            dp[2] = dp[1] + arr[2];
        }
        for(int i = 3; i < n+1; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i]);
        }


        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
