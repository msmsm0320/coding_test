import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선_터뜨리기_review {

    public static class Ballon{

        public int index;
        public int paper;

        public Ballon(int index, int paper){
            this.index = index;
            this.paper = paper;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Ballon> dq = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            dq.add(new Ballon(i + 1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        Ballon bl = dq.pollFirst();
        int paper = bl.paper;

        sb.append(bl.index).append(" ");

        while(dq.size() != 1){
            if(paper < 0){
                for(int i = -1; i>paper; i--){
                    dq.offerFirst(dq.pollLast());
                }
                bl = dq.pollLast();
                sb.append(bl.index).append(" ");
                paper = bl.paper;
            } else {
                for(int i = 1; i<paper; i++){
                    dq.offerLast(dq.pollFirst());
                }
                bl = dq.pollFirst();
                sb.append(bl.index).append(" ");
                paper = bl.paper;
            }

        }

        sb.append(dq.poll().index);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
