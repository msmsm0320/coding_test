import java.io.*;

public class grade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        double m = 0.0;

        String gr[] = {"D", "C", "B", "A"};
        String gr_sub[] = {"+", "0", "-"};

        if (s.length()==1 && s.charAt(0) == 'F'){
            m = 0.0;
        } else{
            for (int i = 0; i <gr.length; i++){
                if (gr[i].equals(String.valueOf(s.charAt(0))))  m += (i+1);
            }
            for (int j = 0; j <gr_sub.length; j++){
                if (gr_sub[j].equals(String.valueOf(s.charAt(1)))) {
                    if(j == 0 ) m+=0.3;
                    else if(j == 2) m-=0.3;
                }
            }
        }
        bw.write(String.valueOf(m));
        bw.flush();
        bw.close();
        br.close();
    }
}
