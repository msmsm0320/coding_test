import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class BOJ_25305_커트라인 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] score = new int[N];
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i<N; i++){
            score[i] = Integer.parseInt(st.nextToken());
        }
        bf.close();

        Arrays.sort(score);

        bw.write(String.valueOf(score[N-k]));
        bw.flush();
        bw.close();

    }
}
