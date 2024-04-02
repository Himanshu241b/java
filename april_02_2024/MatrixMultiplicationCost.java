package April_2;

import java.util.Arrays;

public class MatrixMultiplicationCost {
    public static int minCost(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minCost(arr, 0, n - 1, dp);
    }

    private static int minCost(int[] arr, int i, int j, int[][] dp) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = minCost(arr, i, k, dp) + minCost(arr, k + 1, j, dp)
                    + arr[i] * arr[k + 1] * arr[j + 1];
            minCost = Math.min(minCost, cost);
        }
        dp[i][j] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {4, 5, 3, 2},
                {10, 15, 20, 25},
                {1, 4, 3, 2}
        };

        for (int[] testCase : testCases) {
            System.out.println(minCost(testCase));
        }
    }
}

