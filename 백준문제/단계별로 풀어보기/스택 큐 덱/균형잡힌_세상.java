import javax.lang.model.element.UnknownAnnotationValueException;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌_세상 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String line = sc.nextLine();
            if(line.equals(".")) break;

            Stack<Character> stack = new Stack<>();

            boolean check = true;

            for(int i = 0; i<line.length(); i++){
                char c = line.charAt(i);
                if(c == '(' || c == '[') stack.push(c);
                else if(c == ')') {
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }
                    if(stack.pop() != '(') {
                        check = false;
                        break;
                    }
                } else if(c == ']') {
                     if(stack.isEmpty()){
                         check = false;
                         break;
                     }
                    if(stack.pop() != '[') {
                        check = false;
                        break;
                    }
                } else {
                    continue;
                }
            }
            if(stack.size() != 0) check = false;
            bw.write(check ? "yes\n":"no\n");
        }
        bw.flush();
        bw.close();
    }

}
