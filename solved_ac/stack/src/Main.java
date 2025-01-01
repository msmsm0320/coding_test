import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int arr[] = new int[100001];
    private static int arrSize = 0; // 변수 이름 변경

    private static void push(int X) {
        arr[arrSize] = X;
        arrSize++;
    }

    private static int pop() {
        if (arrSize == 0) return -1;
        arrSize--;
        int tmp = arr[arrSize];
        arr[arrSize] = 0;
        return tmp;
    }

    private static int getSize() { // 메서드 이름 변경
        return arrSize;
    }

    private static int empty() {
        return arrSize == 0 ? 1 : 0;
    }

    private static int top() {
        if (arrSize == 0) return -1;
        return arr[arrSize - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 단순화
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine(), " ");
            String job = str.nextToken();

            switch (job) {
                case "1":
                    if (str.hasMoreTokens()) {
                        push(Integer.parseInt(str.nextToken()));
                    }
                    break;
                case "2":
                    sb.append(pop()).append("\n");
                    break;
                case "3":
                    sb.append(getSize()).append("\n"); // 메서드 이름 변경
                    break;
                case "4":
                    sb.append(empty()).append("\n");
                    break;
                case "5":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.print(sb); // 단순화
    }
}
