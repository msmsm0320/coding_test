import java.io.*;
import java.util.StringTokenizer;

public class 색종이_만들기 {
    static int white = 0;
    static int blue = 0;
    static int[][] paper;

    public static void quarter(int startx, int starty, int endx, int endy){
        int color = paper[startx][starty];
        boolean check = true;
        // 색종이가 같은 색인지 판별
            for(int i = startx; i<endx; i++){
                for(int j = starty; j<endy; j++){
                    if(paper[i][j] != color){
                        check = false;
                        break;
                    }
                    if(!check) break;
                }
            }

            if(check){
                if(color == 0) white++;
                else blue++;
                return;
            }

                int nextx = (endx+startx)/2;
                int nexty = (endy+starty)/2;
                quarter(startx,starty,nextx,nexty);
                quarter(nextx,starty,endx,nexty);
                quarter(startx,nexty,nextx,endy);
                quarter(nextx,nexty,endx,endy);

        }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int check = Integer.parseInt(st.nextToken());
                paper[i][j] = check;
            }
        }
        quarter(0,0,N,N);
        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
