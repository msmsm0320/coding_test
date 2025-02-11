import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int prev = 0;
        int count = 0;

        for(int k : arr){
            count += prev + k;
            prev += k;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
