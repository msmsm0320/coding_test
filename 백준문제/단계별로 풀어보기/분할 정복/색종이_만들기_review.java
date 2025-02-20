import java.io.*;
import java.util.StringTokenizer;

public class 색종이_만들기_review {

    static int white = 0;
    static int blue = 0;
    static int[][] paper;

    public static void quarter(int startx, int endx, int starty, int endy){
        int start = paper[startx][starty];
        boolean check = true;
        for(int i = startx; i<endx; i++){
            for(int j = starty; j<endy; j++){
                if(paper[i][j] != start){
                    check = false;
                    break;
                }
            }
            if(!check) break;
        }

        if(check){
            if(start == 0){
                white++;
                return;
            }else{
                blue++;
                return;
            }
        }

        int nextx = (endx + startx) / 2;
        int nexty = (endy + starty) / 2;

        quarter(startx,nextx,starty,nexty);
        quarter(startx,nextx,nexty,endy);
        quarter(nextx,endx,starty,nexty);
        quarter(nextx,endx,nexty,endy);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        quarter(0,N,0,N);

        bw.write(white+"\n");
        bw.write(blue+"\n");
        bw.flush();
        bw.close();
        br.close();


    }
}
