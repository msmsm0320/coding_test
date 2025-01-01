import java.util.Scanner;

public class AB_repeat_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){ // 종료 조건이 없는 경우 hasNext() 사용하기.
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(A+B);
        }
    }
}
