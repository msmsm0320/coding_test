import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine()," ");

        long N = Long.parseLong(st.nextToken());
        long X = Long.parseLong(st.nextToken());
        long sb[] = new long[(int) N];

        st = new StringTokenizer(bf.readLine(), " ");

        for(int i =0 ; i<N ; i++){
            sb[i] = Integer.parseInt(st.nextToken());
        }

        for (long k : sb){
            if (k < X){
                bw.write(k + " ");
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}