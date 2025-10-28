import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 창문_닫기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0; //창문이 열려있는 개수
        for(int i = 1; i * i <= N; i++) { //제곱수만 카운트
            count++;
        }

        bw.write(count + "\n");

        br.close();

        bw.flush();
        bw.close();
    }
}
