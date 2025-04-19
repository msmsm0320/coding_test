import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 도키도키_간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == count) {

                count++;

                while (!stack.isEmpty() && stack.peek() == count) {
                    stack.pop();
                    count++;
                }
            } else {
                stack.push(num);
            }
        }

        if (stack.isEmpty()) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
