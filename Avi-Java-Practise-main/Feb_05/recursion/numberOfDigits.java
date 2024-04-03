package Feb_05.recursion;

import java.util.Scanner;

public class numberOfDigits {

    static  int solve(long n, int count)
    {
        if(n == 0) return count;

        return solve(n/10, count+1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        int count = 0;
        System.out.println(solve(n, count));
    }
}
