import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class check_num {

    private static int check(String str){

        int checknum=0;
        int num;
        for(int i =0; i<str.length(); i++){
            num = Integer.parseInt(String.valueOf(str.charAt(i))) * Integer.parseInt(String.valueOf(str.charAt(i)));
            checknum += num;
        }
        checknum %=10;

        return checknum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().replaceAll(" ","");
        int checknum = check(str);
        bw.write(String.valueOf(checknum));
        bw.flush();
        bw.close();
        br.close();
    }
}
