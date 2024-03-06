import java.util.Scanner;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = scanner.nextInt();
        System.out.println("Enter value of k:");
        int k = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = aggressiveCows(arr, size, k);
        System.out.println(result);

        scanner.close();
    }

    public static int aggressiveCows(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int low = 1; // Minimum possible distance
        int high = arr[n - 1] - arr[0]; // Maximum possible distance

        int maxMinDistance = 0;

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

    public static boolean isValidDistance(int[] arr, int n, int k, int distance) {
        int cowsPlaced = 1;
        int lastPosition = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - lastPosition >= distance) {
                cowsPlaced++;
                lastPosition = arr[i];
            }
        }

        return cowsPlaced >= k;
    }
}
