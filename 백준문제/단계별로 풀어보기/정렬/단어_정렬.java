import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 단어_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i = 0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr,(e1,e2) -> {
           if(e1.length() == e2.length()){
               return e1.compareTo(e2);
           }else{
               return e1.length() - e2.length();
           }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append("\n");
        for(int j = 1; j<N; j++){
            if(!arr[j].equals(arr[j-1])){
                sb.append(arr[j]).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
