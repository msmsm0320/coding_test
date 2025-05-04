import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 잃어버린_괄호_review {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // '-' 기준으로 나누기
        String[] minusSplit = input.split("-");

        int result = 0;

        for (int i = 0; i < minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            int sum = 0;
            for (String s : plusSplit) {
                sum += Integer.parseInt(s); // 각각 더해줌
            }

            if (i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
