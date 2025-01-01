import java.util.Scanner;

public class AB_repeat_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            if(A !=0 && B !=0) {
                System.out.println(A + B);
            }
            else {break;}
        }
    }
}
