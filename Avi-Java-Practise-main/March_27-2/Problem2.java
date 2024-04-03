public class Problem2 {

    public static int maxRodCuttingCost(int N, int[] A) {
        // Initialize dp array to store maximum cost for each length
        int[] dp = new int[N + 1];
        dp[0] = 0; // Base case: Cost of cutting a rod of length 0 is 0

        // Calculate maximum cost for each rod length
        for (int i = 1; i <= N; i++) {
            dp[i] = A[i - 1]; // Initialize with cost of cutting rod into pieces of length i
            // Try cutting rod at different positions and update maximum cost
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
        }

        // Return maximum cost for rod of length N
        return dp[N];
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {5, 2, 5, 7, 8, 10},
                {8, 3, 5, 8, 9, 10, 17, 17, 20},
                {6, 3, 5, 6, 7, 10, 12}
        };

        for (int[] testCase : testCases) {
            int N = testCase[0];
            int[] A = new int[N];
            System.arraycopy(testCase, 1, A, 0, N);
            System.out.println(maxRodCuttingCost(N, A));
        }
    }
}
