import java.io.*;
import java.util.PriorityQueue;

public class 최소_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Queue = new PriorityQueue<>();

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (Queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(Queue.poll()).append("\n");
                }
            } else {
                Queue.add(x);
            }
        }
        br.close();
        System.out.println(sb);
    }
}
