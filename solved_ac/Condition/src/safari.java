import java.util.Scanner;

public class safari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Long A = scanner.nextLong();
        Long B = scanner.nextLong();

        if (A-B>=0) {
            System.out.println(A-B);
        }
        else System.out.println(Math.abs(A - B));
    }
}
