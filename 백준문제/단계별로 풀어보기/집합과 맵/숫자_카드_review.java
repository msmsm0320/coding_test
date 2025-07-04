import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 숫자_카드_review {

    public static void main(String[] args) throws IOException {

        HashSet<Integer> cards = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < M; i++){
            if(cards.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}
