package March_28;
public class LongestCommonSubstring {

    public static int longestCommonSubstring(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String[] str1 = {"abcjklp", "wasdijkl", "tyfg"};
        String[] str2 = {"acjkp", "wsdjkl", "cvbnuty"};

        for (int i = 0; i < str1.length; i++) {
            System.out.println("Sample Input " + (i + 1) + ":");
            System.out.println(str1[i]);
            System.out.println(str2[i]);
            System.out.println("Sample Output " + (i + 1) + ":");
            System.out.println(longestCommonSubstring(str1[i], str2[i]));
            System.out.println();
        }
    }
}

