import java.util.Scanner;
public class GeometricSumRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter k:");
        int k = sc.nextInt(); // take input
        double res = geometricSum(k); // take result from returned value of function
        System.out.println("Geometric sum: " + res); //print result
    }
    public static double geometricSum(int k) {
        if(k == 0) // base case when k == 0 return 1 which adds 1 to result
            return 1;
        return geometricSum(k-1)+(1/Math.pow(2,k)); // recursively call for (k-1)th term and add 1/2^k
    }
}
    
