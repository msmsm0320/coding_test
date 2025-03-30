import java.io.*;

public class 녹색거탑 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = (int) Math.pow(2,N);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
