import java.io.*;
import java.util.StringTokenizer;

public class 색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int area = 0;

        int[][] paper = new int[100][100];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            for(int j = row; j < row + 10; j++){
                for(int k = col; k < col + 10; k++){
                    if(paper[j][k] == 1) continue;
                    paper[j][k] = 1;
                    area++;
                }
            }
        }

        bw.write(String.valueOf(area));
        bw.flush();
        bw.close();
        br.close();
    }

}
