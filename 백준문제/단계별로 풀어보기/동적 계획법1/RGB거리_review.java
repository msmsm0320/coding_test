import java.io.*;
import java.util.StringTokenizer;

public class RGB거리_review {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        house[0][0] = Integer.parseInt(st.nextToken());
        house[0][1] = Integer.parseInt(st.nextToken());
        house[0][2] = Integer.parseInt(st.nextToken());

        for(int i = 1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<3; j++){
                int curCost = Integer.parseInt(st.nextToken());

                switch(j){
                    case 0 : house[i][0] = Math.min(house[i-1][1] + curCost, house[i-1][2] + curCost);
                        break;
                    case 1 : house[i][1] = Math.min(house[i-1][0] + curCost, house[i-1][2] + curCost);
                        break;
                    case 2:
                        house[i][2] = Math.min(house[i-1][1] + curCost, house[i-1][0] + curCost);
                        break;
                }
            }
        }
        int result = Math.min(house[N-1][0], house[N-1][1]);
        result = Math.min(result, house[N-1][2]);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
