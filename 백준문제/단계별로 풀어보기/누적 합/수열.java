import java.io.*;
import java.util.StringTokenizer;

public class 수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];


        st = new StringTokenizer(br.readLine());

        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N-1; i++){
            arr[i+1] = arr[i] + Integer.parseInt(st.nextToken());
        }

        int max = arr[K - 1];

        for(int i = K; i < N; i++){
            int sum = arr[i] - arr[i-K];
            max = Math.max(sum,max);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
