import java.io.*;
import java.util.Arrays;

public class 대표값_2_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[5];
        int sum = 0;

        for(int i = 0; i<5; i++){
            int k = Integer.parseInt(br.readLine());
            arr[i] = k;
            sum += k;
        }

        Arrays.sort(arr);

        sum /= 5;
        bw.write(sum + "\n");
        bw.write(String.valueOf(arr[2]));
        bw.flush();
        bw.close();
        br.close();
    }
}
