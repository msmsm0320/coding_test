import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 약수_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int[] num = new int[count];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i<count; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        bw.write(String.valueOf(num[0] * num[num.length -1]));
        bw.flush();
        bw.close();
        br.close();
    }

}
