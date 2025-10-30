import java.io.*;
import java.util.StringTokenizer;

public class 분수_합 {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int m = (a * d) + (b * c); //분자
        int n = b * d; //분모

        int k = 0;
        if(m > n) k = gcd(m, n);
        else k = gcd(n, m);

        StringBuilder sb = new StringBuilder();
        sb.append(m/k).append(" ").append(n/k);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
