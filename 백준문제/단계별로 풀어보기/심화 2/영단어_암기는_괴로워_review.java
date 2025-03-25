import java.io.*;
import java.util.*;

public class 영단어_암기는_괴로워_review {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hm = new HashMap();

        for(int i =0; i<N; i++){
            String str = br.readLine();
            if(str.length() < M){
                continue;
            }

            hm.put(str,hm.getOrDefault(str,0)+1);
        }


        List<String> result = new ArrayList<>(hm.keySet());
        Comparator<String> comp = Comparator.comparingInt((String word) -> hm.get(word))
                .thenComparing((String word) -> word.length()).reversed()
                .thenComparing(Comparator.naturalOrder());

        result.sort(comp);

        StringBuilder sb = new StringBuilder();

        for (String s : result) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
