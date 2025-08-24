import java.io.*;
import java.util.StringTokenizer;

public class 알고리즘_수업_점근적_표기_1_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int n0 = Integer.parseInt(st.nextToken());

        if(a1 * n0 + a2 <= c * n0 && c >= a1){
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
