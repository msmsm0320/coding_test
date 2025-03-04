import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좌표_정렬하기_2_review {
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

        Arrays.sort(arr, (y1,y2) -> {
            if(y1[1] == y2[1]){
                return y1[0] - y2[0];
            }else{
                return y1[1] - y2[1];
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int j = 0; j<N; j++){
            sb.append(arr[j][0]).append(" ").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
