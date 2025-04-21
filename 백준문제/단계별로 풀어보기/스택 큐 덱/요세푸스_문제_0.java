import java.io.*;
import java.util.*;

public class 요세푸스_문제_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Queue<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            dq.addLast(i+1);
        }

        sb.append("<");

        int count = 1;
        while(!dq.isEmpty()){
            if(count == K){
                count = 1;
                int j = dq.pollFirst();
                q.offer(j);
                continue;
            }
            else{
                int j = dq.pollFirst();
                dq.offerLast(j);
            }
            count++;
        }

        while(q.size() != 1){
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll());

        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
