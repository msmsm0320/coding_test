import java.io.*;
import java.util.StringTokenizer;

public class 재귀의_귀재_review {

    public static int count;

    public static int isPalindrome(String s, int left, int right){
        count++;
        if(left >= right){
            return 1;
        }
        if(s.charAt(left) == s.charAt(right)) return isPalindrome(s,left+1, right-1) ;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for(int i =0; i<T; i++){
            count = 0;
            String st = br.readLine();

            int result = isPalindrome(st,0,st.length()-1);

            sb.append(result).append(" ").append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
