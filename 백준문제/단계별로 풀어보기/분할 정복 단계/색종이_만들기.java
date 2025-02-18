import java.io.*;
import java.util.StringTokenizer;

public class 색종이_만들기 {
    static int white;
    static int blue;
    static int[] color;
    public static void quarter(int[][] paper){
        if(color[0] == 0){
            blue++;
            return;
        }else if(color[1] == 0){
            white++;
            return;
        }else{
            int last = paper.length;
            int mid = last/2;
            for(int i = 0; i<mid; i++){
                for(int j = 0; j<mid; j++){
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] paper = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int check = Integer.parseInt(st.nextToken());
                color[check]++;
                paper[i][j] = check;
            }
        }
        quarter(paper);
        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
