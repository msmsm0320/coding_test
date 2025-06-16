import java.io.*;
import java.util.StringTokenizer;

public class 구간_합_구하기_4_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N+1];

        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++){
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for(int k = 0; k<M; k++){
            st = new StringTokenizer(br.readLine());

            int sum = 0;

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());


            sum = arr[j] - arr[i-1];

            sb.append(sum).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
