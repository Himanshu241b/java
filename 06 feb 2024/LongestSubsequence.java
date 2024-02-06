import java.util.Scanner;

public class LongestSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int longestLength = 0;
        for (int i = 0; i < n; i++) {
            longestLength = Math.max(longestLength, longestIncreasingSubsequenceLength(arr, n, i));
        }

        System.out.println("Length of the longest increasing subsequence: " + longestLength);

        scanner.close();
    }

    public static int longestIncreasingSubsequenceLength(int[] arr, int n, int index) {
        // Base case: If index reaches the end of the array, return 0
        if (index == n) {
            return 0;
        }

        int maxLength = 0;

        for (int i = index + 1; i < n; i++) {  //       find the length of the LIS for elements after the current index

            if (arr[i] > arr[index]) {
                maxLength = Math.max(maxLength, longestIncreasingSubsequenceLength(arr, n, i));
            }
        }

        // Add 1 to maxLength to account for the current element
        return 1 + maxLength;
    }
}

