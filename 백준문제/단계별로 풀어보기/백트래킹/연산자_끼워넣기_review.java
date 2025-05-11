import java.io.*;
import java.util.StringTokenizer;

public class 연산자_끼워넣기_review {

    public static int Max = Integer.MIN_VALUE;
    public static int Min = Integer.MAX_VALUE;
    public static int[] number;
    public static int[] sign;

    public static void dfs(int depth, int length, int value){
        if(depth == length){
            Max = Math.max(Max, value);
            Min = Math.min(Min, value);
            return;
        }

        for(int i = 0; i<4; i++) {

            // case로 sign을 받는다.
            if (sign[i] > 0) {
                sign[i]--;
                switch (i) {

                    case 0 : {
                        dfs(depth+1, length, value+number[depth]);
                        break;
                    }
                    case 1 : {
                        dfs(depth+1, length, value-number[depth]);
                        break;
                    }
                    case 2 : {
                        dfs(depth+1, length, value*number[depth]);
                        break;
                    }
                    case 3 : {
                        dfs(depth+1, length, value/number[depth]);
                        break;
                    }
                }
                sign[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        number = new int[N];
        sign = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<4; i++){
            sign[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1,N,number[0]);
        bw.write(Max + "\n");
        bw.write(String.valueOf(Min));
        bw.flush();
        bw.close();
        br.close();
    }

}
