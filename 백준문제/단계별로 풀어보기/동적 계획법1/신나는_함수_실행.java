import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 신나는_함수_실행 {

    static StringBuilder sb = new StringBuilder();
    static int[][][] me = new int[21][21][21];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==-1 &&b==-1 &&c==-1)
                break;

            int n = 0;
            n +=w_function(a,b,c);

            sb.append("w(").append(a).append(", ")
                    .append(b).append(", ").append(c)
                    .append(") = ").append(n).append("\n");
        }


        System.out.println(sb);

    }
    public static int w_function(int a, int b, int c) {

        if(a>=0&& a<=20&&b>=0&& b<=20&&c>=0&& c<=20&&me[a][b][c]!=0)
            return me[a][b][c];

        if(a <= 0 || b<=0 || c<=0)
            return 1;

        if (a>20 || b>20 || c>20)
            return me[20][20][20]=w_function(20, 20, 20);

        if (a<b&&b<c)
            return  me[a][b][c]=w_function(a, b, c-1) + w_function(a, b-1, c-1) - w_function(a, b-1, c);


        return me[a][b][c]=w_function(a-1, b, c) + w_function(a-1, b-1, c) +
                w_function(a-1, b, c-1) - w_function(a-1, b-1, c-1);
    }
}