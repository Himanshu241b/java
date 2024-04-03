package Feb_06;

import java.util.Scanner;

public class SumOfDigits {
    //Write a recursive function that returns the sum of the digits of a given integer.

    static int solve(int n, int sum)
    {
        //base cae
        if(n <= 0) return sum;

        //processing
//        getting the last digit and adding to sum
        sum += n%10;

        //call recursive function and dividing n by 10
        return solve(n/10, sum);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();

        System.out.println(solve(n, 0));
    }
}
