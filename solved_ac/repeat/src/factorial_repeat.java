import java.util.Scanner;

public class factorial_repeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = 1;

        for (int i =0; i<N; i++){
            A*=(i+1);
        }
        System.out.println(A);
    }
}
