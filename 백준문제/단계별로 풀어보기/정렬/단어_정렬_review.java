import java.io.*;
import java.util.Arrays;

public class 단어_정렬_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0; i<N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (s1,s2) -> {
           if(s1.length() == s2.length()){
               return s1.compareTo(s2);
           }else{
               return s1.length() - s2.length();
           }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0] + "\n");
        for(int j = 1; j<N; j++){
            if(!arr[j].equals(arr[j-1])){
                sb.append(arr[j] + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
