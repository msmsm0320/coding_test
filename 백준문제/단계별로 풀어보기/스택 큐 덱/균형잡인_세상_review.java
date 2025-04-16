import java.io.*;
import java.util.Stack;

public class 균형잡인_세상_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            if(line.equals("."))break;
            boolean result = true;
            for(int i=0; i<line.length(); i++){
                char c = line.charAt(i);
                switch(c) {
                    case '(':
                    case '[': stack.push(c);
                    break;
                    case ')': if (stack.isEmpty() || stack.pop() != '(') result = false;
                    break;
                    case ']': if (stack.isEmpty() || stack.pop() != '[') result = false;
                    break;
                }
                if(!result) break;
            }
            if(!stack.isEmpty()) result = false;
            bw.write(result?"yes\n":"no\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
