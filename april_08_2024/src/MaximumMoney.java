public class MaximumMoney {
    public int maxMoney(int[] A) {
        int n = A.length;

        // Initialize a 2D array for dynamic programming
        int[][] dp = new int[n][n];

        // Fill the dp array
        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                if (length == 1) {
                    dp[i][j] = A[i];
                } else if (length == 2) {
                    dp[i][j] = Math.max(A[i], A[j]);
                } else {
                    dp[i][j] = Math.max(A[i] + Math.min(dp[i+2][j], dp[i+1][j-1]),
                            A[j] + Math.min(dp[i+1][j-1], dp[i][j-2]));
                }
            }
        }

        // Return the maximum amount of money you can win
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        MaximumMoney solution = new MaximumMoney();

        int[] A1 = {1, 2, 3, 4};
        System.out.println(solution.maxMoney(A1));  // Output: 6

        int[] A2 = {5, 4, 8, 10};
        System.out.println(solution.maxMoney(A2));  // Output: 15
    }
}
