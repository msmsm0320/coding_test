import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
public class 나는야_포켓몬_마스터_이다솜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<Integer, String> hm2 = new HashMap<>();

        int count = 1;

        for(int i = 0; i < N; i++){
            String pocketmon = br.readLine();
            hm1.put(pocketmon,count);
            hm2.put(count++,pocketmon);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            String pc = br.readLine();

            if(49 <= pc.charAt(0) && pc.charAt(0) <= 57){
                sb.append(hm2.get(Integer.parseInt(pc))).append(" ").append("\n");
            } else{
                sb.append(hm1.get(pc)).append(" ").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
