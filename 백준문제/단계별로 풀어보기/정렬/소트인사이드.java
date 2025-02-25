import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        String[] arr = N.split("");

        Arrays.sort(arr, Comparator.reverseOrder());

        for(String k : arr){
            bw.write(k);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
