import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 풍선_터뜨리기 {

    public static class Balloon {

        private int index;
        private int paper;

        public Balloon(int index, int paper) {
            this.index = index;
            this.paper = paper;
        }

        public int getIndex() {
            return index;
        }

        public int getPaper() {
            return paper;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            Balloon b = new Balloon(i + 1, Integer.parseInt(st.nextToken()));
            dq.addLast(b);
        }

        StringBuilder sb = new StringBuilder();

        Balloon balloon1 = dq.pollFirst();

        int paper = balloon1.getPaper();

        sb.append(balloon1.getIndex()).append(" ");
        Balloon rs;
        while (dq.size() != 1) {

            if (paper < 0) {
                for (int i = -1; i > paper; i--) {
                    dq.offerFirst(dq.pollLast());
                }
                rs = dq.pollLast();
            } else {
                for (int i = 1; i < paper; i++) {
                    dq.offerLast(dq.pollFirst());
                }
                rs = dq.pollFirst();
            }

            sb.append(rs.getIndex()).append(" ");
            paper = rs.getPaper();
        }

        sb.append(dq.poll().getIndex());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
