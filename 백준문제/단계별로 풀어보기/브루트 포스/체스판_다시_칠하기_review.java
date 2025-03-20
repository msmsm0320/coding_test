import java.io.*;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기_review {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[][] board = new String[N][M];

        // 보드 입력 받기
        for(int i = 0; i<N; i++){
            String line = br.readLine();
            for(int j = 0; j<M; j++){
                board[i][j] = String.valueOf(line.charAt(j));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int startX = 0; startX<=N-8; startX++){
            for(int startY = 0; startY<=M-8; startY++){
                int countW = 0;
                int countB = 0;
                for(int k = startX; k<startX+8; k++){
                    for(int l = startY; l<startY+8; l++){
                        String current = board[k][l];

                        if((k+l)%2 == 0){
                            if(!current.equals("W")) countW++;
                            if(!current.equals("B")) countB++;
                        } else {
                            if(!current.equals("W")) countB++;
                            if(!current.equals("B")) countW++;
                        }
                    }
                }

                min = Math.min(min, Math.min(countW, countB));
            }
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

}
