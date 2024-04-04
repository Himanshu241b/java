import java.util.Arrays;
import java.util.Scanner;

public class ClosestSum {
    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int n = A.length;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = A[i] + A[left] + A[right];
                int diff = Math.abs(sum - B);

                if (diff == 0) {
                    return sum; // Exact match found
                }

                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                if (sum < B) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] A = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int B = scanner.nextInt();

        // Find the closest sum
        int closestSum = threeSumClosest(A, B);
        System.out.println("Closest sum to " + B + ": " + closestSum);

        scanner.close();
    }
}

