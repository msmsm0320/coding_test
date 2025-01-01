import java.util.Scanner;

class P_CHECK{
    private int check = 1;

    public void p_check(char[] a){
        int k = a.length-1;
        for (int i = 0;i<a.length;i++){
            if (a[i]!=a[k]){
                this.check=0;
                break;
            }

            k--;
        }
        System.out.println(this.check);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        char[] charArray = word.toCharArray();

        P_CHECK palindromeChecker = new P_CHECK();

        palindromeChecker.p_check(charArray);

        scanner.close();
    }
}
