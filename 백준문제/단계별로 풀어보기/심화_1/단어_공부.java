import java.io.*;
import java.util.HashMap;

public class 단어_공부 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = br.readLine().toUpperCase();

        int arr[] = new int[26];

        for(int i = 0; i < target.length(); i++){
            int num = target.charAt(i) - 'A';
            arr[num]++;
        }

        int max = Integer.MIN_VALUE;
        char answer = '?';

        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                answer = (char)(i + 'A');
            } else if(max == arr[i]) {
                answer = '?';
            }
        }

        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();

    }

}