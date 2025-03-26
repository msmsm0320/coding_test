import java.io.*;
import java.util.HashSet;

public class 인사성_밝은_곰곰이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                count += hs.size();
                hs = new HashSet<>();
            } else hs.add(str);
        }
        count += hs.size();

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

}
