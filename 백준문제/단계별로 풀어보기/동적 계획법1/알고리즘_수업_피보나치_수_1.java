import java.io.*;

public class 알고리즘_수업_피보나치_수_1 {

    public static int f[] = new int[40];
    public static int code1 = 0;
    public static int code2 = 0;

    public static int fib(int n){
        if(n==1 || n == 2){
            code1++;
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static int fibonacci(int n){
        for(int i = 2; i<n; i++){
            code2++;
            f[i] = f[i-1] + f[i-2];
        }
        return code2;
    }

    public static void main(String[] args) throws IOException {
        f[0] = 1;
        f[1] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        fib(N);
        fibonacci(N);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(code1)+ "\n");
        bw.write(String.valueOf(code2));
        bw.flush();
        bw.close();
        br.close();
    }
}
