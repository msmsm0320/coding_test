import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 가장_긴_바이토닉_부분_수열 {

    public static int[] r_dp;
    public static int[] l_dp;
    public static int[] array;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        r_dp = new int[N];
        l_dp = new int[N];
        array = new int[N];

        Arrays.fill(r_dp, 1);
        Arrays.fill(l_dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, r_dp[i] + l_dp[i] - 1);
        }

        System.out.println(max);
        br.close();
    }

    public static void LIS() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    r_dp[i] = Math.max(r_dp[i], r_dp[j] + 1);
                }
            }
        }
    }

    public static void LDS() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (array[j] < array[i]) {
                    l_dp[i] = Math.max(l_dp[i], l_dp[j] + 1);
                }
            }
        }
    }
}
