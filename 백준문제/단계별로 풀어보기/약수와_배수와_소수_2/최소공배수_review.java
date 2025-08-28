import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 최소공배수_review {

    public static int gcd(int a, int b){

        if(b == 0) return a;
        return gcd(b, a % b);

    }

    public static int lcm(int a, int b){
        return a * (b / gcd(a,b));
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lcm(a,b)).append("\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}