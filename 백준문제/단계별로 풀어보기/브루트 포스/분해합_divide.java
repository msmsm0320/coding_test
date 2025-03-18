import java.io.*;

public class 분해합_divide {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = 0;

        for(int i = 1; i<N; i++){

            int length = String.valueOf(i).length();
            int num = i;
            int sum = num;

            for(int j = 0; j<length; j++){
                int divNum = num % 10;
                sum += divNum;
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
