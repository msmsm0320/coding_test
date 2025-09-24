import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class 절대값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) ->{
            if(Math.abs(o1) == Math.abs(o2)){
                return o1 - o2;
            }
            return Math.abs(o1) - Math.abs(o2);
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(pq.size() == 0){
                    sb.append(0).append("\n");
                    continue;
                }

                sb.append(pq.poll()).append("\n");
            }else{
                pq.offer(x);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
