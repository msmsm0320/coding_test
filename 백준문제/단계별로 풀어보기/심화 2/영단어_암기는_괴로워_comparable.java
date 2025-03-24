import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 영단어_암기는_괴로워_comparable {

    public static void main(String[] args) throws IOException {

//                1. 자주 나오는 단어일수록 앞에 배치한다.
//                2. 해당 단어의 길이가 길수록 앞에 배치한다.
//                3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            if(str.length() < M) continue;
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        ArrayList<String> result = new ArrayList<>(hm.keySet());

        result.sort((o1,o2) -> {
            if(!hm.get(o1).equals(hm.get(o2))){
                return hm.get(o2) - hm.get(o1);
            } else if (o1.length() != o2.length()){
                return o2.length() - o1.length();
            } else{
                return o1.compareTo(o2);
            }
        });

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
