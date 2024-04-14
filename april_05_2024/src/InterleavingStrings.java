import java.util.Scanner;

public class InterleavingStrings {
    public static int isInterleave(String A, String B, String C) {
        int m = A.length();
        int n = B.length();

        // If the sum of lengths of A and B is not equal to the length of C,
        // then C cannot be formed by interleaving A and B
        if (m + n != C.length()) {
            return 0;
        }

        // dp[i][j] indicates whether C[0...(i+j-1)] is formed by interleaving A[0...i-1] and B[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Initialize dp[0][0] as true since empty strings can be interleaved to form an empty string
        dp[0][0] = true;

        // Fill the first row of dp
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && B.charAt(j - 1) == C.charAt(j - 1);
        }

        // Fill the first column of dp
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && A.charAt(i - 1) == C.charAt(i - 1);
        }

        // Fill the rest of the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1))
                        || (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
            }
        }

        // Return 1 if the last cell of dp is true, indicating that C is formed by interleaving A and B
        return dp[m][n] ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string A: ");
        String A = scanner.nextLine();

        System.out.print("Enter string B: ");
        String B = scanner.nextLine();

        System.out.print("Enter string C: ");
        String C = scanner.nextLine();

        int result = isInterleave(A, B, C);
        System.out.println("Output: " + result);

        scanner.close();
    }
}
