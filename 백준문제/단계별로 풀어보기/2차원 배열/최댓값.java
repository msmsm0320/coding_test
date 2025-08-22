import java.io.*;
import java.util.StringTokenizer;

public class 최댓값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[9][9];

        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > max){
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(String.valueOf(max)).append("\n").append(String.valueOf(row+1)).append(" ").append(String.valueOf(col+1));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
