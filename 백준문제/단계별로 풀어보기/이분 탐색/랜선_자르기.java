import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 랜선_자르기 {

    public static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long max = 0;
        for(int i = 0; i < K; i++){
            long x = Long.parseLong(br.readLine());
            list.add(x);
            if(x > max) max = x;

        }

        max++;

        long min = 1;
        long mid = 0;

        while(min < max) {

            mid = (max + min)/2;

            long count = 0;

            for(int i = 0; i < list.size(); i++){
                count += list.get(i)/mid;
            }

            if(count < N){
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        bw.write(String.valueOf(min-1));
        bw.flush();
        bw.close();
        br.close();

    }

}
