import java.util.Scanner;

public class InterleavingStrings {
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

    public static int isInterleave(String A, String B, String C) {
        int m = A.length(), n = B.length();

        // If lengths of A and B don't add up to the length of C, it's impossible to form C by interleaving A and B
        if (m + n != C.length())
            return 0;

        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case initialization
        dp[0][0] = true;

        // Fill the first row
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && B.charAt(j - 1) == C.charAt(j - 1);
        }

        // Fill the first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && A.charAt(i - 1) == C.charAt(i - 1);
        }

        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)) ||
                        (dp[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1));
            }
        }

        // Return the result
        return dp[m][n] ? 1 : 0;
    }
}
