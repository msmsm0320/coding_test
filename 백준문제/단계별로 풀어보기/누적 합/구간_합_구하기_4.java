import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N+1];
        st = new StringTokenizer(br.readLine());

        arr[0] = 0;

        for(int i = 0; i<N; i++){
            arr[i+1] = arr[i] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int sum = arr[b] - arr[a-1];
            sb.append(sum).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
