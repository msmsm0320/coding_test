import java.io.*;
import java.util.Arrays;

public class 대표값_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        int sum = 0;
        for(int i = 0; i<5; i++){
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum+=n;
        }

        sum/=5;
        Arrays.sort(arr);

        bw.write(sum + "\n");
        bw.write(String.valueOf(arr[2]));
        bw.flush();
        bw.close();
        br.close();
    }
}
