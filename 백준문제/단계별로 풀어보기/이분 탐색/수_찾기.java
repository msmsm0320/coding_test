import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 수_찾기 {

    public static List<Integer> list = new ArrayList<>();

    public static int binarySearch(int target, int start, int end){
        while(start <= end){
            int pivot = (start + end)/2;
            if(list.get(pivot) > target){
                end = pivot-1;
            } else if(list.get(pivot) < target){
                start = pivot+1;
            } else{
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = list.size()-1;

            sb.append(binarySearch(target, start, end)).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
