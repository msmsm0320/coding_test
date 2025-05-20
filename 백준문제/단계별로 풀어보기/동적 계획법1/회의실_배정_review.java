import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실_배정_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] meeting = new int[N][2];

        StringTokenizer st;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<2; j++){
                meeting[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(meeting, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int lastFinishedTime = 0;
        int count = 0;

        for(int[] k : meeting){
            if(lastFinishedTime <= k[0]){
                count++;
                lastFinishedTime = k[1];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
