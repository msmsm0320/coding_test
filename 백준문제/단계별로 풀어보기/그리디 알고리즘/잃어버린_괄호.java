import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class 잃어버린_괄호 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String exp = br.readLine();

        String[] minusSplit =exp.split("-");

        int result = 0;

        for(int i = 0; i<minusSplit.length; i++){
            String[] plusSplit = minusSplit[i].split("\\+");

            int sum = 0;

            for(String num : plusSplit){
                sum += Integer.parseInt(num);
            }

            if(i == 0){
                result += sum;
            } else{
                result -= sum;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
