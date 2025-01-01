import java.io.*;
import java.util.StringTokenizer;

public class matrix_add {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int arr1[][] = new int[N][M];
        int arr2[][] = new int[N][M];


        for (int i = 0; i<N ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int k = 0; k<M ; k++){
                arr1[i][k] = Integer.parseInt(st.nextToken());

            }
        }
        for (int j = 0; j<N ; j++){
            st = new StringTokenizer(br.readLine()," ");
            for(int l = 0; l<M; l++){
                arr2[j][l] = Integer.parseInt(st.nextToken());
            }

        }
        for (int i =0; i<N ; i++){
            for (int j = 0; j<M; j++){
                bw.write(arr1[i][j] + arr2[i][j]+ " ");
                if(j==M-1) bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
