import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            q.offer(i+1);
        }

        int count = 1;
        while(q.size() != 1){
            if(count % 2 == 1){
                q.poll();
            } else {
                int k = q.poll();
                q.offer(k);
            }
            count++;
        }

        bw.write(String.valueOf(q.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
}
