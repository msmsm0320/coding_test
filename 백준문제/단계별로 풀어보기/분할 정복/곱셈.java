import java.io.*;
import java.util.StringTokenizer;

public class 곱셈 {

    public static long C;

    public static long pow(long A, long exponent){

        if(exponent == 1){
            return A % C;
        }

        long tmp = pow(A, exponent / 2);

        if(exponent % 2 == 1){
            return (tmp % C * tmp % C) * A % C;
        }
        return tmp % C * tmp % C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(pow(A, B)));
        bw.flush();
        bw.close();
        br.close();
    }
}
