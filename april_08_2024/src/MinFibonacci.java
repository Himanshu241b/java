import java.util.ArrayList;
import java.util.List;

public class MinFibonacci {
    public int MinimumFibonacciNumbers(int A) {
        // Generate Fibonacci numbers until we get a Fibonacci number greater than or equal to A
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1); // First Fibonacci number
        fibonacci.add(1); // Second Fibonacci number
        int i = 2;
        while (fibonacci.get(i - 1) + fibonacci.get(i - 2) <= A) {
            fibonacci.add(fibonacci.get(i - 1) + fibonacci.get(i - 2));
            i++;
        }

        // Use dynamic programming to find the minimum number of Fibonacci numbers required
        int count = 0;
        int index = fibonacci.size() - 1;
        while (A > 0) {
            while (fibonacci.get(index) > A) {
                index--; // Move to the previous Fibonacci number
            }
            A -= fibonacci.get(index);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        MinFibonacci solution = new MinFibonacci();

        int A1 = 4;
        System.out.println(solution.MinimumFibonacciNumbers(A1));  // Output: 2

        int A2 = 7;
        System.out.println(solution.MinimumFibonacciNumbers(A2));  // Output: 2
    }
}

