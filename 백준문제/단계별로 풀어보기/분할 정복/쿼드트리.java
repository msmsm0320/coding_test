import java.io.*;
import java.util.StringTokenizer;

public class 쿼드트리 {
    public static int[][] arr;
    public static StringBuilder sb;

    public static boolean isPossible(int x, int y, int size){
        int value = arr[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(value != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void quadTree(int startx, int starty, int size){

        if(isPossible(startx, starty, size)) {
            sb.append(arr[startx][starty]);
            return;
        }

        sb.append("(");

        int nextSize = size / 2;

        quadTree(startx, starty, nextSize);
        quadTree(startx, starty + nextSize, nextSize);
        quadTree(startx + nextSize, starty, nextSize);
        quadTree(startx + nextSize, starty + nextSize, nextSize);

        sb.append(")");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String st = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = st.charAt(j) - '0';
            }
        }
        quadTree(0,0,N);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
