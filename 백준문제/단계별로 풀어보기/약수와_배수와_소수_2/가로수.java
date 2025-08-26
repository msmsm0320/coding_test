import java.io.*;

public class 가로수 {

    public static int GCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int arr[] = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int gcd = arr[1]-arr[0];

        for(int i = 1; i < N-1; i++){
            gcd = GCD(gcd,arr[i+1]-arr[i]);
        }

        int count = 0;

        for(int i = 0; i < N-1; i++){
            count += (arr[i+1] - arr[i])/gcd - 1;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
