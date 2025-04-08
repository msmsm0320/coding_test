import java.io.*;

public class 하노이_탑_이동_순서 {

    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        bw.write(String.valueOf((int)(Math.pow(2,N) - 1)));
        bw.write("\n");

        Hanoi(N,1,2,3);

        bw.flush();
        bw.close();


    }

    public static void Hanoi(int N, int start, int mid, int to) throws IOException{

        if(N==1){
            bw.write(start + " " + to + "\n");
            return;
        }

        Hanoi(N-1,start, to, mid);

        bw.write(start + " " + to  + "\n");

        Hanoi(N-1, mid, start, to);
    }
}
