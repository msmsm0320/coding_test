import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 커트라인_review {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(scores);

        bw.write(String.valueOf(scores[N-k]));
        br.close();
        bw.flush();
        bw.close();
    }
}
