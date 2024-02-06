import java.util.Scanner;
public class FibonacciRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the number you want in fibonacci sequence:");
        int n = sc.nextInt(); // take input
        int res = fibo(n); // call the fibonacci function
        System.out.println("The fibonacci number is: " + res);
    }
    public static int fibo(int n) {
        if(n == 1)  // base case 1 : when n == 1 the first fibonacci no.- 0 is returned
            return 0;
        else if (n == 2)  // base case 2 : when n == 2 the second fibonacci no.- 1 is returned
            return 1;
        else
            return fibo(n-1)+fibo(n-2); // recursively call for (n-1) + (n-2) number for nth number
    }
}
