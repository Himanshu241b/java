import java.util.Scanner;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the size of the array
        System.out.println("Enter size of array:");
        int size = scanner.nextInt();

        // Prompt user to enter the value of k
        System.out.println("Enter value of k:");
        int k = scanner.nextInt();

        // Initialize an array of size 'size'
        int[] arr = new int[size];

        // Prompt user to enter elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Call the aggressiveCows method to compute the maximum minimum distance
        int result = aggressiveCows(arr, size, k);
        System.out.println(result);

        scanner.close();
    }

    // Method to compute the maximum minimum distance
    public static int aggressiveCows(int[] arr, int n, int k) {
        // Sort the array in ascending order
        Arrays.sort(arr);

        // Initialize the minimum and maximum possible distance
        int low = 1; // Minimum possible distance
        int high = arr[n - 1] - arr[0]; // Maximum possible distance

        // Initialize the maximum minimum distance
        int maxMinDistance = 0;

        // Perform binary search to find the maximum minimum distance
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValidDistance(arr, n, k, mid)) {
                maxMinDistance = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return maxMinDistance;
    }

    // Method to check if a given distance is valid
    public static boolean isValidDistance(int[] arr, int n, int k, int distance) {
        // Initialize the number of cows placed and the position of the last placed cow
        int cowsPlaced = 1;
        int lastPosition = arr[0];

        // Iterate through the array to place cows and check if the distance is valid
        for (int i = 1; i < n; i++) {
            if (arr[i] - lastPosition >= distance) {
                cowsPlaced++;
                lastPosition = arr[i];
            }
        }

        // Check if the number of cows placed is greater than or equal to k
        return cowsPlaced >= k;
    }
}
