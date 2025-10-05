import java.io.*;
import java.util.StringTokenizer;

public class 나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int low = 1;
        int high = 0;
        int mid = 0;


        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(arr[i], high);
        }

        while(low <= high){
            mid = (low + high) / 2;
            long sum = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] - mid >= 0) sum += (arr[i] - mid);
            }

            if(sum < T) high = mid-1;
            else if (sum >= T) low = mid+1;
        }
        bw.write(String.valueOf(high));
        bw.flush();
        bw.close();
        br.close();

    }
}
