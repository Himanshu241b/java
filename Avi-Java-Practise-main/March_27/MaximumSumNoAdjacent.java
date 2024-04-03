import java.util.Scanner;

public class MaximumSumNoAdjacent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of test cases: ");
        int T = scanner.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            System.out.print("Enter the size of the array: ");
            int N = scanner.nextInt(); // Size of the array
            int[] arr = new int[N]; // Array to store elements

            System.out.print("Enter the elements of the array separated by space: ");
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt(); // Input array elements
            }
            System.out.println("Maximum sum of non-adjacent elements: " + maximumSumNoAdjacent(arr)); // Calculate and print the maximum sum
        }
    }

    public static int maximumSumNoAdjacent(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        if (n == 2) return Math.max(arr[0], arr[1]);

        // Initialize variables to store the maximum sums ending at the current index
        int incl = arr[0];
        int excl = 0;
        int exclNew;

        // Traverse the array and update incl and excl values
        for (int i = 1; i < n; i++) {
            exclNew = Math.max(incl, excl);


            incl = excl + arr[i];
            excl = exclNew;
        }

        // Return the maximum of incl and excl as the final maximum sum
        return Math.max(incl, excl);
    }
}
