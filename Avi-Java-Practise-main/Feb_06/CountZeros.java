package Feb_06;

import java.util.Scanner;

public class CountZeros {
    //Given an integer N, count and return the number of zeros that are present in the given
    // integer using recursion.

    static int solve(int n, int count)
    {
        //base case
        if(n == 0) return count;

        //processing
        int digit = n%10; //fetching the number to check
        if(digit == 0) count++;

        return solve(n/10, count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        System.out.println(solve(n, 0));
    }
}
