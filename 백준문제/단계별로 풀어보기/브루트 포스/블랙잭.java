import java.io.*;
import java.util.StringTokenizer;

public class 블랙잭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int j = 0; j<N; j++){
            int sum = 0;
            for(int k = 0; k<N; k++){
                if(j == k) continue;
                for(int l = 0; l<N; l++){
                    if( l == j || l == k) continue;
                    sum = arr[j] + arr[k] + arr[l];
                    if(sum > max && sum <= M){
                        max = sum;
                    }
                }
            }
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

}
