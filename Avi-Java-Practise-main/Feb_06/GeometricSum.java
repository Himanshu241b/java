package Feb_06;

import java.util.Scanner;

public class GeometricSum {

    static double solve(double n, double ans)
    {
        //base case
        if(n == 0) return ans;

        //adding 1/2^n to ans and decrementing n after that and making the function call
        ans += (double) 1 / Math.pow(2, n);
        return solve(n-1, ans);
    }
    public static void main(String[] args) {
        //Given k, find the geometric sum i.e.
        //1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k)
        //Note :
        //using recursion.

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the n: ");
        int n = sc.nextInt();

        //storing the result in ans + 1
        double ans = 1+ solve(n, 0);
        System.out.println(ans);
    }
}
