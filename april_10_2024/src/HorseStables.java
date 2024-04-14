import java.util.*;

public class HorseStables {

    public static int arrangeHorses(String horses, int K) {
        int n = horses.length();
        int[][] dp = new int[n + 1][K + 1];

        // Initialize the dp array with maximum values
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Base case: no stable, no horses
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= K; j++) {
                int white = 0, black = 0;

                // Calculate number of white and black horses from index i to end
                for (int k = i; k <= n; k++) {
                    if (horses.charAt(k - 1) == 'W') {
                        white++;
                    } else {
                        black++;
                    }

                    // Check if current stable arrangement is better than previous
                    if (dp[k][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], white * black + dp[k][j - 1]);
                    }
                }
            }
        }

        // If no valid arrangement is found, return -1
        return dp[n][K] == Integer.MAX_VALUE ? -1 : dp[n][K];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sequence of horses
        System.out.print("Enter the sequence of black and white horses (e.g., WWWB): ");
        String horses = scanner.next();

        // Input number of stables
        System.out.print("Enter the number of stables (K): ");
        int K = scanner.nextInt();

        int result = arrangeHorses(horses, K);
        System.out.println("Minimum product sum for accommodating horses: " + result);
    }
}
