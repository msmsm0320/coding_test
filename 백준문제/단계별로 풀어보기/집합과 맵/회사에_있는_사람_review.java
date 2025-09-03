import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 회사에_있는_사람_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hs = new HashSet<>();


        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String p = st.nextToken();
            String c = st.nextToken();

            if(c.equals("enter")){
                hs.add(p);
            } else {
                hs.remove(p);
            }
        }

        StringBuilder sb = new StringBuilder();

        ArrayList<String> result = new ArrayList<>(hs);

        Collections.sort(result);

        for(int i = result.size()-1; i >= 0; i--){
            sb.append(result.get(i)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
