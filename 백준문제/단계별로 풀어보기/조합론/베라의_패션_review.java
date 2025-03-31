import java.io.*;

public class 베라의_패션_review {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = N*(N-1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
