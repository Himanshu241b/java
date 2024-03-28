import java.util.Scanner;

public class LongestCommonSubString {
    public static int longestCommonSubstringLength(String str1, String str2) {
        int lengthString1 = str1.length();
        int lengthString2 = str2.length();


        int[][] dp = new int[lengthString1 + 1][lengthString2 + 1];

        // Variable to store the length of the longest common substring
        int maxLength = 0;

        // Fill dp table bottom-up
        for (int i = 1; i <= lengthString1; i++) {
            for (int j = 1; j <= lengthString2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        // Call the function and print the result
        System.out.println("Length of longest common substring: " + longestCommonSubstringLength(str1, str2));
        scanner.close();
    }
}
