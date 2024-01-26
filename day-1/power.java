import java.util.Scanner;
import java.util.*;
class power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x: ");
        int x = sc.nextInt();
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int ans = findPower(x, n);
        System.out.println(ans);
}
    public static int findPower(int x, int n) {
        if(n == 0)
            return 1;
        int ans = 1;
        while(n > 0){
            ans *= x;
            --n;
        }
        return ans;
        }
    
}