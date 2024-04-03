package Feb_06;

import java.util.Scanner;

public class Multiplication {
    //Given two integers M & N, calculate and return their multiplication using recursion.
    // You can only use subtraction and addition for your calculation. No other operators are allowed.

    //method
    static int solve(int n1, int n2, int product)
    {
        //base case
        if(n2 == 0) return product;

        product += n1;

        return solve(n1, n2-1, product);
    }
    public static void main(String[] args) {

        //taking number input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int n1 = sc.nextInt();
        System.out.println("Enter the 2nd number");
        int n2 = sc.nextInt();

        //saving in prodct
        int product = solve(n1, n2, 0);
        System.out.println(product);

    }
}
