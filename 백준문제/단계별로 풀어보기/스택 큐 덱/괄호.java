import java.io.*;

public class 괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            count = 0;
            String line = br.readLine();
            for(int j = 0; j<line.length(); j++){
                if(line.charAt(j) == ')'){
                    count--;
                    if(count < 0){
                        break;
                    }
                } else{
                    count++;
                }
            }
            if(count == 0) bw.write("YES"+"\n");
            else bw.write("NO" + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
