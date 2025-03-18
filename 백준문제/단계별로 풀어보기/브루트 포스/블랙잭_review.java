import java.io.*;
import java.util.StringTokenizer;

public class 블랙잭_review {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cards[]= new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;

        for(int j = 0; j<N; j++){
            int sum = 0;
            for(int k = j+1; k<N; k++){
                for(int l = k+1; l<N; l++){
                    sum = cards[j] + cards[k] + cards[l];
                    if(sum <= M && sum > max){
                        max = sum;
                    }
                }
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();

    }
}
