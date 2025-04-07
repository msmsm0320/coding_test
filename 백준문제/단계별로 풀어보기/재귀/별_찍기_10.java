import java.io.*;

public class 별_찍기_10 {

    public static String arr[][];

    public static void paintStar(int x, int y, int N, boolean blank){

        if(blank){
            for(int i = x; i<x+N; i++){
                for(int j = y; j<y+N; j++){
                    arr[i][j] = " ";
                }
            }
            return;
        }

        if(N==1) {
            arr[x][y] = "*";
            return ;
        }

        int size = N / 3;
        int count = 0;

        for(int i = x; i<x+N; i += size){
            for(int j = y; j<y+N; j += size){
                count++;
                if(count == 5){
                    paintStar(i,j,size,true);
                } else{
                    paintStar(i,j,size, false);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        arr = new String[N][N];

        paintStar(0,0,N,false);

        for(int i=0; i<N; i++){
            for(int j =0; j<N; j++){
                bw.write(arr[i][j]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
