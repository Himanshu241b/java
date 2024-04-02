import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();


        System.out.println("Enter the elements of the array:");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }


        int longestSubsequenceLength = findLongestIncreasingSubsequenceLength(arr);


        System.out.println("Length of the longest strictly increasing subsequence: " + longestSubsequenceLength);

   ;
    }

    private static int findLongestIncreasingSubsequenceLength(int[] arr) {
        int length = arr.length;
        int[] dp = new int[length];
        int maxLength = 1;

        // Initialize dp array with 1 as the minimum length of LIS for each index
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }

        // Calculate LIS length for each index
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }
}
