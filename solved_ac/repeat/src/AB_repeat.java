import java.util.Scanner;

public class AB_repeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int A;
        int B;

        for(int i =0; i<T ; i++){
            A = scanner.nextInt();
            B = scanner.nextInt();

            System.out.println(A+B);
        }
    }
}
