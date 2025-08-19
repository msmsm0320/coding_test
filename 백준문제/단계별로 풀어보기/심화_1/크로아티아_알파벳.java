import java.io.*;

public class 크로아티아_알파벳 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine();

        int num = 0;

        for(int i = 1; i < target.length(); i++){

            char a =target.charAt(i);

            if(a == '-') num++;

            if (a == '=') {
                if(target.charAt(i-1) == 'z'){
                    if( i>=2 && target.charAt(i-2) == 'd') num+=2;
                    else num++;
                    continue;
                }
                num++;
            }

            if (a == 'j'){
                if(target.charAt(i-1) == 'n' || target.charAt(i-1) == 'l') num++;
            }
        }

        bw.write(String.valueOf(target.length()-num));
        bw.flush();
        bw.close();
        br.close();
    }

}
