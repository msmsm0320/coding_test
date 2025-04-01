import java.io.*;

public class 팩토리얼_2 {

    public static long factorial(int N){
        if(N<=1) return 1;

        return N *factorial(N-1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(factorial(N)));
        bw.flush();
        bw.close();
        br.close();
    }
}
