import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class count {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int count=0;
        int array[] = new int[N];
        int v;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());

        for (int j : array){
            if(j == v){
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
