import java.io.*;
import java.util.HashSet;

public class 인사성_밝은_곰곰이_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();
        int result = 0;

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                result += hs.size();
                hs = new HashSet<>();
                continue;
            }
            hs.add(str);

        }
        result += hs.size();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}
