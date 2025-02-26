import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표_정렬하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr,(e1,e2) ->{
            if(e1[1] == e2[1]){
                return e1[0] - e2[0];
            }else{
                return e1[1] - e2[1];
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int[] k: arr){
            sb.append(k[0] + " " + k[1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
