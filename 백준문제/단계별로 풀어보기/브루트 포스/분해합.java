import java.io.*;

public class 분해합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = 0;

        for(int i = 1; i<N; i++){
            int length = String.valueOf(i).length(); // 계산할 i의 자릿수
            int sum = i;

            for(int j = 0; j<length; j++){
                 int nextNum =Integer.parseInt(String.valueOf(String.valueOf(i).charAt(j)));
                 sum += nextNum;
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
