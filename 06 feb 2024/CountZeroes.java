import java.util.Scanner;
public class CountZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the number");
        int k = sc.nextInt(); // take input

    }

    public static int countZeros(int n) {
        if (n == 0) {        // if the number is zero, return 1

            return 1;
        }
        else if (n < 10) {        //  if the number is non-zero and less than 10, return 0

            return 0;
        }
        else if (n % 10 == 0) {         // if the last digit is zero, add 1 to the count and recursively call countZeros

            return 1 + countZeros(n / 10);
        }
        else {          //if the last digit is non-zero, recursively call countZeros

            return countZeros(n / 10);
        }
    }
}
