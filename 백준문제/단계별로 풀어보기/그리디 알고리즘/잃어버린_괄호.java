import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine(); // 수식 입력 받기

        // '-' 기준으로 나누기
        String[] minusSplit = input.split("-");

        int result = 0;

        for (int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+"); // '+' 기준으로 또 나누기
            int sum = 0;
            for (String s : plusSplit) {
                sum += Integer.parseInt(s); // 각각 더해줌
            }

            if (i == 0) {
                result += sum; // 첫 번째 그룹은 더함
            } else {
                result -= sum; // 이후는 모두 빼줌
            }
        }

        System.out.println(result);
    }
}
