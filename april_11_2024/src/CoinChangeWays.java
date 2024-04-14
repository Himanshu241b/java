public class CoinChangeWays {

    static int coinChangeWays(int[] coins, int targetSum) {
        final int MOD = 1000007;
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= targetSum; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        return dp[targetSum];
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int B = 4;
        System.out.println(coinChangeWays(A, B));
    }
}
