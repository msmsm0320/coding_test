import java.io.*;
import java.util.Arrays;

public class submit_assignment {
    public static void main(String[] args) throws IOException {
        int org[] = new int[30];
        for (int i = 0; i<30 ; i++){
            org[i] = i+1;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int submit[] = new int [28];

        for(int j = 0; j < 28 ; j++){
            submit[j] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(submit);
        int n = 0;
        int m = 0;
        while(n < 30){
            if (m<28 && org[n] == submit[m]) {
                n++;
                m++;
            } else bw.write(org[n++]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}