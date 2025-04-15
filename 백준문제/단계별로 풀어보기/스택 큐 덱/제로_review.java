import java.io.*;
import java.util.Stack;

public class 제로_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        for(int i =0; i<K; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0 && !stack.isEmpty()) {
                stack.pop();
            } else if (N == 0 && stack.isEmpty()) {
                continue;
            } else {
                stack.push(N);
            }
        }

            int result = 0;
            while(!stack.isEmpty()){
                result+= stack.pop();
            }

            bw.write(String.valueOf(result));
            bw.flush();
            br.close();
            bw.close();
        }
    }

