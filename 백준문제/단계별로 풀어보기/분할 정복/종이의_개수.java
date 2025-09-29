import java.io.*;
import java.util.StringTokenizer;

public class 종이의_개수 {
    public static int[][] arr;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    public static boolean isPossible(int x, int y, int size){
        int recent = arr[x][y];
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(recent != arr[i][j]) return false;
            }
        }
        return true;
    }

    public static void countPaper(int x, int y, int size){
        if(isPossible(x,y,size)){
            if(arr[x][y] == -1) minus++;
            if(arr[x][y] == 0) zero++;
            if(arr[x][y] == 1) plus++;
            return;
        }

        int newSize = size / 3;
        countPaper(x,y,newSize);
        countPaper(x,y+newSize,newSize);
        countPaper(x,y+newSize+newSize,newSize);
        countPaper(x+newSize,y,newSize);
        countPaper(x+newSize,y+newSize,newSize);
        countPaper(x+newSize,y+newSize+newSize,newSize);
        countPaper(x+newSize+newSize,y,newSize);
        countPaper(x+newSize+newSize,y+newSize,newSize);
        countPaper(x+newSize+newSize,y+newSize+newSize,newSize);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int size = arr.length;

        countPaper(0,0,size);

        StringBuilder sb = new StringBuilder();
        sb.append(minus).append("\n").append(zero).append("\n").append(plus);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
