import java.io.*;
import java.util.Scanner;

public class 칸토어_집합_review{

    public static String[] arr;

    public static void cantorSet(int start, int len) {
        if (len==1) return;

        int size = len / 3;

        for (int i = start + size; i<start + 2 * size; i++) {
            arr[i] = " ";
        }

        cantorSet(start, size);
        cantorSet(start + 2 * size, size);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int size = (int) Math.pow(3, N);
            arr = new String[size];

            for (int i = 0; i < size; i++) {
                arr[i] = "-";
            }

            cantorSet(0, size);

            for (String str : arr) {
                bw.write(str);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
