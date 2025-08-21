import java.io.*;
import java.util.StringTokenizer;

public class 너의_평점은 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double gpa = 0;
        double total = 0;


        for(int i = 0; i < 20; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            double score = 0;

            switch(grade) {
                case "A+": score = 4.5;
                break;
                case "A0": score = 4.0;
                break;
                case "B+": score = 3.5;
                    break;
                case "B0": score = 3.0;
                    break;
                case "C+": score = 2.5;
                    break;
                case "C0": score = 2.0;
                    break;
                case "D+": score = 1.5;
                    break;
                case "D0": score = 1.0;
                    break;
                case "F": score = 0.0;
                    break;
                case "P": continue;

            }

            gpa+= credit*score;
            total += credit;

        }

        if(gpa == 0){
            bw.write(String.format("%.6f",gpa));
        }else{
            bw.write(String.format("%.6f", gpa/total));
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
