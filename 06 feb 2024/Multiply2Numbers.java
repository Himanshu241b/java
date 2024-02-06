import java.util.Scanner;

        public class Multiply2Numbers {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in); // Initialize scanner object 
                System.out.println("Enter first integer");
                int m = sc.nextInt();// take input
                System.out.println("Enter second integer");
                int n = sc.nextInt();
                System.out.println("Result:"+multiply(m, n));
            }
        
            public static int multiply(int m, int n) {
                
                if ((m < 0 && n > 0) || (m > 0 && n < 0)) {
                    return -multiply(Math.abs(m), Math.abs(n)); //when one number is negative and one is positive
                } else if (m < 0 && n < 0) {
                    m = Math.abs(m);// If both numbers are negative, make them positive
                    n = Math.abs(n);
                }
            
                
                if (m == 0 || n == 0) //if either m or n is zero, return 0
                    return 0;
                
                
                else if (n == 1) // if n is 1, return m
                    return m;
                
                // add m to the result of multiplying m by (n - 1)
                else 
                    return m + multiply(m, n - 1);
                
            }
            
        }

