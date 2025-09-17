import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 문자열_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String,Integer> hm = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            hm.put(s,i);
        }

        for(int i = 0; i < M; i++){
            String t = br.readLine();
            if(hm.containsKey(t)) result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}