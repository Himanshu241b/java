import java.util.*;
public class countDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        int count = countDigits(n);
        System.out.println(count);
    }
    public static int countDigits(int n) {
        
        if(n == 0)
            return 0;

        return countDigits(n/10)+1;

    }
}
