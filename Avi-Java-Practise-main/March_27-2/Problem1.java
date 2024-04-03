public class Problem1 {

    public static int countPartitions(int[] arr, int n, int d) {
        int mod = 1000000007;

        // Maximum possible sum of array elements
        int maxSum = 50 * n;

        // Initialize a 2D array to store counts
        int[][] dp = new int[n + 1][maxSum + 1];

        // Base case: There is one way to have an empty partition with sum 0
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= maxSum; j++) {
                // Copy counts from previous row
                dp[i + 1][j] = dp[i][j];

                // Update counts for current element
                if (j >= arr[i]) {
                    dp[i + 1][j] += dp[i][j - arr[i]];
                    dp[i + 1][j] %= mod;
                }
            }
        }

        // Count partitions with desired difference
        int count = 0;
        for (int s1 = d; s1 <= maxSum; s1++) {
            int s2 = s1 - d;
            count += dp[n][s1];
            count %= mod;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {4, 3, 5, 2, 6, 4},
                {4, 0, 1, 1, 1, 1},
                {5, 1, 3, 2, 2, 5, 1}
        };

        for (int[] testCase : testCases) {
            int n = testCase[0];
            int d = testCase[1];
            int[] arr = new int[n];
            System.arraycopy(testCase, 2, arr, 0, n);
            System.out.println(countPartitions(arr, n, d));
        }
    }
}
