import java.io.*;
import java.util.Stack;

public class 제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<K; i++){
            int N = Integer.parseInt(br.readLine());

            if(N != 0){
                stack.push(N);
            }else if(N == 0 && stack.empty()){
                continue;
            }
            else {
                stack.pop();
            }
        }

        int result = 0;
        for (Integer i : stack) {
            result+=i;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
