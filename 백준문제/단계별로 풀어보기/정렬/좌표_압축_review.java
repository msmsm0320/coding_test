import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표_압축_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        int sorted[] = new int[N];

        for(int i = 0; i<N; i++){
            int el = Integer.parseInt(st.nextToken());
            arr[i] = el;
            sorted[i] = el;
        }

        Arrays.sort(sorted);

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int rank = 0;

        for(int j = 0; j<N; j++){
            if(!hashMap.containsKey(sorted[j])) {
                hashMap.put(sorted[j], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int k : arr){
            sb.append(hashMap.get(k)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

}
