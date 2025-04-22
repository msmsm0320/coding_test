import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제_0_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<N; i++){
            q.offer(i+1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int count = 1;

        while(q.size() != 1){
            if(count == T ) {
                sb.append(q.poll()).append(", ");
                count = 1;
            } else {
                int k = q.poll();
                q.offer(k);
                count++;
            }
        }

        sb.append(q.poll()).append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
