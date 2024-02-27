//imports
import java.util.Arrays;
import java.util.Scanner;

class WildcardMatching {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String str = sc.next();
        System.out.println("Enter pattern :");
        String pattern = sc.next();
        if(isMatch(str, pattern))
            System.out.println("Wildcard string matches");
        else
            System.out.println("Wildcard string does not match");

    }
    public static boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        return helper(s, p, s.length()-1, p.length()-1, dp);
    }
    public static boolean helper(String s, String p, int i, int j, int[][] dp){
        if(i < 0 && j < 0)
            return true;
        if(i >= 0 && j < 0)
            return false;
        if(i < 0 && j >=0){
            for(int k = 0; k <= j; ++k){
                if(p.charAt(k)!= '*')
                    return false;
            }
            return true;
        }

        if(dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean result = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            result = helper(s, p, i-1, j-1, dp);
        if(p.charAt(j) == '*')
            result = helper(s, p, i-1, j, dp) || helper(s, p, i, j-1, dp);

        dp[i][j] = result ? 1 : 0;
        return result;
    }
}