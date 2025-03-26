import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 붙임성_좋은_총총이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();
        hs.add("ChongChong");

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String people1 = st.nextToken();
            String people2 = st.nextToken();

            if(hs.contains(people1)){
                hs.add(people2);
            } else if(hs.contains(people2)){
                hs.add(people1);
            }
        }

        bw.write(String.valueOf(hs.size()));
        bw.flush();
        bw.close();
        br.close();

    }

}
