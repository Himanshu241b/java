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

    /**
     * method to check if the string matches the pattern
     * @param s input string
     * @param p input pattern
     * @return true if the string matches the pattern
     */
    public static boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()]; // initialize 2d array for memoization
        for(int[] arr : dp) // fill the dp array with -1
            Arrays.fill(arr, -1);
        return helper(s, p, s.length()-1, p.length()-1, dp);
    }

    /**
     * helper method to check if the string matches the pattern
     * @param s input string
     * @param p input pattern
     * @param stringIndex last index of input string
     * @param patternIndex last index of pattern string
     * @param dp 2d array to memoize the repeating work
     * @return
     */
    public static boolean helper(String s, String p, int stringIndex, int patternIndex, int[][] dp){
        if(stringIndex < 0 && patternIndex < 0) // string has matched the pattern completely
            return true;
        if(stringIndex >= 0 && patternIndex < 0) //string is still not matched but pattern is complete
            return false;
        if(stringIndex < 0 && patternIndex >=0){ // string has been completely iterated but pattern is still left
            for(int k = 0; k <= patternIndex; ++k){ //checks if the remaining characters in pattern are '*'
                if(p.charAt(k)!= '*')
                    return false;
            }
            return true;
        }
        //check memoized array to see if we already have the result
        if(dp[stringIndex][patternIndex] != -1)
            return dp[stringIndex][patternIndex] == 1;

        boolean result = false;
        // when the characters match or pattern has '?'
        if(s.charAt(stringIndex) == p.charAt(patternIndex) || p.charAt(patternIndex) == '?')
            result = helper(s, p, stringIndex-1, patternIndex-1, dp);
        // when the pattern has '*' we can use it or ignore it
        if(p.charAt(patternIndex) == '*')
            result = helper(s, p, stringIndex-1, patternIndex, dp) || helper(s, p, stringIndex, patternIndex-1, dp);

        dp[stringIndex][patternIndex] = result ? 1 : 0;
        return result;
    }
}