import java.io.*;
import java.util.StringTokenizer;

public class 킹_퀸_룩_비숍_나이트_폰{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] arr = {1,1,2,2,2,8};

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]-Integer.parseInt(st.nextToken())).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
