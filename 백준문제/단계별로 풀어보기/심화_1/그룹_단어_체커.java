import java.io.*;

public class 그룹_단어_체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            boolean flag = false;

            for(int j = 0; j < str.length()-1; j++){
                boolean diffch = false;
                char ch = str.charAt(j);

                for(int l = j+1; l < str.length(); l++){
                    if(diffch == true && str.charAt(j) == str.charAt(l)){
                        flag = true;
                    }

                    if(diffch == false && str.charAt(j) != str.charAt(l)){
                        diffch = true;
                        ch = str.charAt(l);
                    }
                }

            }

            if(!flag) count++;


        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

}
