import java.io.*;
import java.util.StringTokenizer;

public class 이항_계수_1 {
    public static int fact(int k){
        int result = 1;
        for(int i = 1; i<=k; i++){
            result*=i;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = fact(N)/(fact(N-K)*fact(K));

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
