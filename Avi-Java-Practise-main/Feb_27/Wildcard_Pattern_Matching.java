package Feb_27;

public class Wildcard_Pattern_Matching {

    static int solve(String pattern, String str, int i, int j, int dp[][])
    {
        //base cases

        //ofcourse i and j < 0 means traverse all strings and found matching elements only
        if(i < 0 && j < 0) return 1;

            //if elements are left in str array but not in pattern, then obviusly not matching
        else if(i < 0 && j >= 0) return 0;

            // checking if left elements in pattern are just stars or not
        else if(i >= 0 && j < 0)
        {
            for(int ii=i; ii>=0; ii--)
            {
                if(pattern.charAt(ii) != '*') return 0;
            }
            return 1;
        }

        if(dp[i][j] != -1) return dp[i][j];

        //storing the string in char
        char ch1 = pattern.charAt(i);
        char ch2 = str.charAt(j);

        //checking the first condition in which 2 elemnets are same or one of the chars is "?",
        // both iteration will be decreased by 1
        if(ch1 == ch2 || ch1 == '?') return dp[i][j] = solve(pattern, str, i-1, j-1, dp);

            //checking the 2nd condition in which pattern is "*", then further checking of str need to be done
            //untill we don't find a matching element with the pattern behind "*"
        else if(ch1 == '*')
        {
            //now what we need to do is that we need to checking for two cases
            //1. in which we don't consider the "*" and check for previous element checking (matches or not)
            //2. in which we consider the "*" and decrementing str by 1 and check for first case again
            //if we find matching chars behind "*", then it'll be checked by upper conditions✌

            return dp[i][j] = solve(pattern, str, i-1, j, dp) | solve(pattern, str, i, j-1, dp);
        }

        //if nothing matches, then ch1 != ch2, then return false
        else return dp[i][j] = 0;

    }

    public static void main(String[] args) {
        String pattern = "";
        String str = "";

        int n = pattern.length();
        int m = str.length();

        //create a dp metrix for 2 changing elements i and j and initializing it with -1
        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++) dp[i][j] = -1;
        }

        //function call
        System.out.println(solve(pattern, str, n-1, m-1, dp));
    }
}
