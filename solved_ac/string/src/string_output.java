import java.io.*;

public class string_output {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;

        while((str = br.readLine())!=null){
            bw.write(str+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
