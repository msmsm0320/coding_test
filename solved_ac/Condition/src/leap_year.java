import java.util.Scanner;

public class leap_year {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = scanner.nextInt();

        if(year%4 == 0){
            if (year%100 != 0 || year%400 == 0){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
        else {
            System.out.println("0");
        }
    }
}
