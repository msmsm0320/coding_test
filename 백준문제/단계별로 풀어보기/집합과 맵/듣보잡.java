import java.io.*;
import java.util.*;

public class 듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> hs = new HashSet<>();

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            hs.add(s);
        }

        StringBuilder sb = new StringBuilder();

        List<String> result = new ArrayList<>();

        for(int j = 0; j < M; j++){
            String str = br.readLine();
            if(hs.contains(str)){
                result.add(str);
            }
        }

        Collections.sort(result);
        sb.append(result.size()).append("\n");

        for(String s : result){
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
