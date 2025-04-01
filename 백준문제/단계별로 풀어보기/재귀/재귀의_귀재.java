import java.io.*;

public class 재귀의_귀재 {
    public static int count;
    public static int isPalindrome(int left,int right, String str){
        if(left>=right){
            count++;
            return 1;
        }

        if(str.charAt(left) == str.charAt(right)){
            count++;
            return isPalindrome(left+1,right-1,str);
        }else{
            count++;
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<T; i++){
            count = 0;
            String str = br.readLine();
            int pal = isPalindrome(0,str.length()-1,str);

            sb.append(pal).append(" ").append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
