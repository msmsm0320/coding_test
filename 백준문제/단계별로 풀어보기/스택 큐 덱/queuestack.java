import java.io.*;
import java.util.*;

public class queuestack {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] type = new int[N];
        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            type[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            if (type[i] == 0){
                queue.offerLast(num[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<M; i++){
            int next = Integer.parseInt(st.nextToken());
            queue.addFirst(next);
            next = queue.removeLast();
            sb.append(next).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
