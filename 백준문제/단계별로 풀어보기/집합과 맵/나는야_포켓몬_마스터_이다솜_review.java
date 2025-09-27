import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> hm = new HashMap<>();

        int count = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String Pocketmon = br.readLine();
            hm.put(Pocketmon,count++);
        }

        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < M; j++){
            String pm = br.readLine();
            try{
                int n = Integer.parseInt(pm);
                for(String key : hm.keySet()){
                    if(hm.get(key) == n) sb.append(key).append(" ").append("\n");
                }
            }catch (NumberFormatException e){
                sb.append(hm.get(pm)).append(" ").append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
