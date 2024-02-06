import java.util.Scanner;
public class FactorialRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the number ");
        int n = sc.nextInt(); // take input
        int result = factorial(n); // call function and store returned value to result
        System.out.println("Factorial :"+result); // prints the factorial
        sc.close(); //close scanner object 
    }
    public static int factorial(int n) {
        if(n == 0) // base case when n is 0 
            return 1;
        return factorial(n-1) * n; // else call recursively for (n-1)th number multiplied by the number
    }
}
