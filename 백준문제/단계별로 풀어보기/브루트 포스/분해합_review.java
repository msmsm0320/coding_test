import java.io.*;

public class 분해합_review {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = 0;

        for(int i = 1; i<N; i++){
            int sum = i;
            int num = i;
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            if(sum == N){
                M = i;
                break;
            }
        }
        bw.write(String.valueOf(M));
        bw.flush();
        bw.close();
        br.close();
    }

}
