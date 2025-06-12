import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대_힙_review {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i<N; i++){
            
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.size() == 0){
                    bw.write(0 + "\n");
                    continue;
                }
                bw.write(pq.poll() + "\n");
            }else{
                pq.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
