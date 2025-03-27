import java.io.*;
import java.util.*;

import static java.lang.Math.round;

public class 통계학 {

        public static int arithmetic_mean(int[] arr){
            double result = 0;
            for (int i : arr) {
                result += i;
            }

            return (int) round(result /arr.length);
        }

        public static int median(int[] arr){
            int result = arr[arr.length/2];
            return result;
        }

        public static int mode(int[] arr){
            HashMap<Integer,Integer> hm = new HashMap<>();
            List<Integer> list = new ArrayList<>();

            for (int i : arr) {
                hm.put(i,hm.getOrDefault(i,0)+1);
            }
            int max = Integer.MIN_VALUE;
            int maxKey = 0;
            for (int i : hm.keySet()) {
                if(max < hm.get(i)){
                    max = hm.get(i);
                    maxKey = i;
                }
            }

            for (int i : hm.keySet()) {
                if(hm.get(i) == max){
                    list.add(i);
                }
            }
            if(list.size() == 1){
                return list.get(0);
            } else{
                Collections.sort(list);
                return list.get(1);
            }
        }

        public static int range(int[] arr){
            return arr[arr.length -1] - arr[0];
        }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int arithmetic_mean = arithmetic_mean(arr);
        int median = median(arr);
        int mode = mode(arr);
        int range = range(arr);

        StringBuilder sb = new StringBuilder();
        sb.append(arithmetic_mean).append("\n").append(median).append("\n").append(mode).append("\n").append(range);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
