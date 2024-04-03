public class Problem4 {

    public static long robHouses(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0]; // Only one house to rob

        // Calculate maximum amount of money if including first house and excluding last house
        long[] dp1 = new long[n];
        dp1[0] = arr[0];
        dp1[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + arr[i]);
        }

        // Calculate maximum amount of money if excluding first house and including last house
        long[] dp2 = new long[n];
        dp2[0] = 0; // No money if not including first house
        dp2[1] = arr[1];
        for (int i = 2; i < n; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + arr[i]);
        }

        // Return maximum of the two cases
        return Math.max(dp1[n - 2], dp2[n - 1]);
    }

    public static void main(String[] args) {
        int[][] testCases = {
                {1},
                {0},
                {2, 3, 2},
                {1, 3, 2, 1},
                {1, 5, 1, 2, 6},
                {2, 3, 5},
                {1, 3, 2, 0}
        };

        for (int[] testCase : testCases) {
            System.out.println(robHouses(testCase));
        }
    }
}
