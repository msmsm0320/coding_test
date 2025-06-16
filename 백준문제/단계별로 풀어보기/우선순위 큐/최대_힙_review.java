import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대_힙_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
            } else {
                pq.offer(x);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
