package March_28;

public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false; // If sum is odd, can't partition into equal subsets
        }
        sum /= 2; // Calculate the target sum

        boolean[][] dp = new boolean[n + 1][sum + 1];
        // Base case: dp[i][0] = true for all i, since we can achieve sum 0 with any number of elements
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    // If the current number can be included in the sum
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    // If the current number is too large to be included
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {3, 1, 1, 2, 2, 1},
                {5, 6, 5, 11, 6},
                {2, 2, 1, 1, 1, 1, 1, 3, 3},
                {8, 7, 6, 12, 4, 5}
        };

        for (int[] testCase : testCases) {
            System.out.println(canPartition(testCase));
        }
    }
}

