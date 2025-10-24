import java.io.*;
import java.util.*;

public class 보석_도둑 {
    static class Jewel {
        int w;
        int v;
        Jewel(int w, int v) { this.w = w; this.v = v; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(jewels, (a, b) -> Integer.compare(a.w, b.w));
        Arrays.sort(bags);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0L;
        int idx = 0;

        for (int cap : bags) {
            while (idx < N && jewels[idx].w <= cap) {
                maxHeap.offer(jewels[idx].v);
                idx++;
            }
            if (!maxHeap.isEmpty()) {
                total += maxHeap.poll();
            }
        }

        System.out.println(total);
    }
}
