import java.util.Scanner;
public class SumOfInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the String to test:");
        String s = sc.next(); // take input
        System.out.println("sum is: "+sumOfDigits(s));
    }

    public static int sumOfDigits(int n) {
        if (n < 10) {         //if the number is a single digit, return the number itself

            return n;
        }
        else {
            
            int lastDigit = n % 10;// Extract the last digit
            
            int remainingDigits = n / 10;// Divide the number by 10 to remove the last digit
            return lastDigit + sumOfDigits(remainingDigits);  // Recursively calculate the sum of the remaining digits

        }
    }
}
