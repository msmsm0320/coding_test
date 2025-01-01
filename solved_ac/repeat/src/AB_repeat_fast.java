import java.io.*;

public class AB_repeat_fast {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine()); // 테스트 케이스 수 입력

        for (int i = 0; i < T; i++) {
            String[] input = bf.readLine().split(" "); // 한 줄에 두 개의 숫자를 입력받음
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            bw.write((A + B) + "\n"); // 계산 결과를 문자열로 변환하여 출력
        }

        bw.flush(); // 버퍼 비우기
        bw.close(); // BufferedWriter 닫기
        bf.close(); // BufferedReader 닫기
    }
}
