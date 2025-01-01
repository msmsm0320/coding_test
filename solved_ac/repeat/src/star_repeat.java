import java.util.Scanner;

public class star_repeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        for(int i = 1 ; i<N+1; i++){
            for(int j = 0; j<i; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
