import java.io.*;
import java.util.StringTokenizer;

public class 주유소_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] charge = new int[N];
        int[] distance = new int[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            charge[i] = Integer.parseInt(st.nextToken());
        }

        int Min = charge[0];
        long sum = 0;

        for(int i = 0; i<N-1; i++){
            Min = Math.min(charge[i],Min);
            sum += (long) Min*distance[i];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
