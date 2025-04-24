import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class queuestack_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] type = new int[N];
        int[] value = new int[N];

        Deque<Integer> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            type[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
            if (type[i] == 0) {
                dq.addLast(value[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<M; i++){
            dq.addFirst(Integer.parseInt(st.nextToken()));
            int k = dq.pollLast();
            sb.append(k).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
