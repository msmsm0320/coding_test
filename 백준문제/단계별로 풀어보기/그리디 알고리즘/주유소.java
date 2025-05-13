import java.io.*;
import java.util.StringTokenizer;

public class 주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] city = new int[N-1];
        int[] charge = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N-1; i++){
            city[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            charge[i] = Integer.parseInt(st.nextToken());
        }

        long totalCost = 0;
        int minPrice = charge[0];

        for(int i = 0; i<N-1; i++){
            if(charge[i] < minPrice){
                minPrice = charge[i];
            }
            totalCost += (long) minPrice * city[i];
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(totalCost));
        bw.flush();
        bw.close();
        br.close();
    }
}
