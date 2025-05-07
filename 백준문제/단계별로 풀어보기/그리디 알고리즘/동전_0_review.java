import java.io.*;
import java.util.StringTokenizer;

public class 동전_0_review {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];

        for(int i = N-1; i>=0; i--){
            coin[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i=0; i<N; i++){
            count += K/coin[i];
            K %=coin[i];
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
