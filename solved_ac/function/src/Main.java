import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static long cal(long A, long B){
        long result = (A+B)*(A-B);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        bw.write(String.valueOf(cal(A,B)));
        bw.flush();
        bw.close();
        br.close();
    }
}