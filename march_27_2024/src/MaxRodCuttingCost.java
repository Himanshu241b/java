import java.util.Scanner;

public class MaxRodCuttingCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the rod : ");
        int Length = scanner.nextInt();

        int[] lengths = new int[Length];
        System.out.print("Enter the costs associated with each sub-length: ");
        for (int i = 0; i < Length; i++) {
            lengths[i] = scanner.nextInt();
        }

        int result = maxRodCuttingCost(Length, lengths);
        System.out.println("Maximum cost obtained: " + result);


    }

    public static int maxRodCuttingCost(int Length, int[] lengths) {
        int[] dp = new int[Length + 1];

        // Initialize the dp array
        for (int i = 1; i <= Length; i++) {
            dp[i] = lengths[i - 1]; // Cost if we cut the rod into pieces of length i
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        // Return the maximum cost for the rod of length N
        return dp[Length];
    }
}
