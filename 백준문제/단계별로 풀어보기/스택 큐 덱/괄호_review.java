import java.io.*;
import java.util.Stack;

public class 괄호_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int T = Integer.parseInt(br.readLine());


        for(int i = 0; i<T; i++){
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            boolean result = true;
            for(int j = 0; j<line.length(); j++){
                if(line.charAt(j)== '('){
                    stack.push('(');
                }else{
                    if(stack.isEmpty()){
                        result = false;
                        break;
                    }
                    if(stack.pop() == ')'){
                        result = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) result = false;
            bw.write(result?"YES\n":"NO\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
