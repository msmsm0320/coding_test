import java.io.*;

public class 명령_프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();

        char arr[] = new char[first.length()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = first.charAt(i);
        }

        for(int i = 1; i < N; i++){
            String cur = br.readLine();

            for(int j = 0; j < arr.length; j++){
                if(cur.charAt(j) != arr[j]) arr[j] = '?';
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
