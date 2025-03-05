import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수_정렬하기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            int k = Integer.parseInt(br.readLine());
            list.add(k);
        }
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for(int j : list){
            sb.append(j).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
