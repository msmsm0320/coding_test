import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] divisor = new int[num];


        st= new StringTokenizer(br.readLine());

        for(int i = 0; i<num; i++){
            divisor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(divisor);

        int N = divisor[0] * divisor[num-1];
        bw.write(String.valueOf(N));
        bw.flush();
        bw.close();
        br.close();
    }
}
