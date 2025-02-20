import java.io.*;
import java.util.Arrays;

public class 수_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        for(int i = 0; i<N ; i++){
            int num = Integer.parseInt(br.readLine());
            array[i] = num;
        }

        Arrays.sort(array);

        for(int k : array){
            bw.write(k + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
