import java.io.*;

public class charandstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int i = Integer.parseInt(br.readLine())-1;

        bw.write(s.charAt(i));
        bw.flush();
        bw.close();
        br.close();

    }
}
