import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 다음_소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i =0; i< T; i++){
            long N = Long.parseLong(br.readLine());
            if (N <= 1) N = 2;
            while(true){
                int count = 0;
                for(int j = 2; j<=Math.sqrt(N); j++){
                    if(N%j==0){
                        count++;
                        break;
                    }
                }

                if(count == 0){
                    System.out.println(N);
                    break;
                }
                N++;
            }
        }
    }
}
