import java.io.*;
import java.util.*;

public class 영단어_암기는_괴로워_comparable_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hm = new HashMap<>();

        for(int i = 0; i<N; i++){
            String line = br.readLine();
            if(line.length() < M) continue;

            hm.put(line, hm.getOrDefault(line,0) +1);
        }

        List<String> list = new ArrayList<>(hm.keySet());

        list.sort((o1, o2) ->{
            if (!hm.get(o1).equals(hm.get(o2))) {
                return hm.get(o2) - hm.get(o1);
            } else if (o1.length() != o2.length()){
                return o2.length() - o1.length();
            }else{
                return o1.compareTo(o2);
            }
                }
        );

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
