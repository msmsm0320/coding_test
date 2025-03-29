import java.io.*;
import java.util.*;

import static java.lang.Math.round;

public class 통계학_review {

    public static int arithmetic_mean(int[] arr){
        // 산술평균 : N개의 수들의 합을 N으로 나눈 값(소수점 이하 첫째 자리에서 반올림)
        double result = 0;
        for (int i : arr) {
            result +=i;
        }
        return (int) round(result/arr.length);
    }

    public static int median(int[] arr){
        // 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        return arr[arr.length/2];
    }

    public static int mode(int[] arr){
        // 최빈값 : N개의 수들 중 가장 많이 나타나는 값
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }

        int maxValue = Integer.MIN_VALUE;
        int maxKey;

        for (Integer i : hm.keySet()) {
            if(hm.get(i) > maxValue){
                maxKey = i;
                maxValue = hm.get(i);
            }
        }

        for (Integer i : hm.keySet()) {
            if(hm.get(i) == maxValue){
                list.add(i);
            }
        }

        if(list.size() == 1){
            return list.get(0);
        } else {
            Collections.sort(list);
            return list.get(1);
        }
    }

    public static int range(int[] arr){
        // 범위 : N개의 수들 중 최댓값과 최솟값의 차이
        return arr[arr.length-1] - arr[0];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        sb.append(arithmetic_mean(arr)).append("\n")
                .append(median(arr)).append("\n")
                .append(mode(arr)).append("\n")
                .append(range(arr)).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}
