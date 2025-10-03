import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    public static int[] visited = new int[100_001];

    public static void bfs(int start, int target){
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur == target) return;

            int[] nexts = {cur - 1, cur + 1, 2 * cur};
            for(int next : nexts){
                if(next < 0 || next > 100_000) continue;
                if(visited[next] != -1) continue;
                visited[next] = visited[cur] + 1;
                q.add(next);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N,K);

        bw.write(String.valueOf(visited[K]));
        bw.flush();
        bw.close();
        br.close();


    }
}
