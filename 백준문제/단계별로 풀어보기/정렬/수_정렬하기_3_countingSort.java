import java.io.*;

public class 수_정렬하기_3_countingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count[] = new int[10001];

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            count[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i< 10001; i++){
            while(count[i] > 0){
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
