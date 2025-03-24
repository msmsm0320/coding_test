import java.io.*;

public class 설탕_배달 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        for(int i = 0; i<N; i++){
            int sum = 0;
            for(int j = 0; j<N; j++){
                sum = (i*5 + j*3);

                if(sum == N && (i+j) < min){
                    min = i+j;
                }
            }
        }

        if(min == Integer.MAX_VALUE){
            bw.write(String.valueOf(-1));
        } else{
            bw.write(String.valueOf(min));
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
