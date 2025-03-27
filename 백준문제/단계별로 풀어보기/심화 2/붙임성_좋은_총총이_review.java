import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 붙임성_좋은_총총이_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();

        hs.add("ChongChong");

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if(hs.contains(str1)){
                hs.add(str2);
            } else if (hs.contains(str2)){
                hs.add(str1);
            }
        }

        bw.write(String.valueOf(hs.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}
