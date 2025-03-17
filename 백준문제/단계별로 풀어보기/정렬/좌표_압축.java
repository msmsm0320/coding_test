import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좌표_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] arr2 = new int[N];
        for(int i = 0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            arr2[i] = n;
        }

        Arrays.sort(arr2);

        HashMap<Integer,Integer> hm = new HashMap<>();
        int rank = 0;

        for(int num : arr2){
            if(!hm.containsKey(num)){
                hm.put(num, rank++);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num : arr){
            sb.append(hm.get(num)).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
