package Feb_06;

import java.util.Scanner;

public class nCr {

    static int fact(int n, int f)
    {
        //base case
        if(n == 0) return f;

        f *= n;
        return fact(n-1, f);
    }
    public static void main(String[] args) {
        //Program to calculate value of nCr using Recursion
        //Given two numbers N and r, find the value of NCr using recursion

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n");
        int n = sc.nextInt();

        System.out.println("Enter r");
        int r = sc.nextInt();

        int nCr = fact(n, 1) / (fact(r, 1) * fact(n-r, 1));

        System.out.println(nCr);
    }
}
