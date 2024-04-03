import java.util.Scanner;

public class TargetSumWays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array and the target sum:");
        int size = scanner.nextInt();
        int targetSum = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int elemnet = 0; elemnet < size; elemnet++) {
            arr[elemnet] = scanner.nextInt();
        }

        System.out.println("Number of ways to achieve the target sum: " + findWays(arr, targetSum));
    }

    public static int findWays(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i]; j--) {
                dp[j] += dp[j - arr[i]];
            }
        }

        return dp[k];
    }
}
