import java.io.*;

public class string_length {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        bw.write(String.valueOf(s.length()));

        bw.flush();
        bw.close();
        br.close();
    }
}
