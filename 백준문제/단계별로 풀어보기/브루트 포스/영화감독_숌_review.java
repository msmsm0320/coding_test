import java.io.*;

public class 영화감독_숌_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int num = 666;

        while(count != N){
            num++;
            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();
        br.close();
    }
}
