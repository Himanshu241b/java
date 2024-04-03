package Feb_06;

import java.util.Scanner;

public class Seperate_adjacant_chars {
    //Given a string S, compute recursively a new string where
    //identical chars that are adjacent in the original string are separated from each other by a "*".
    //Sample Input 2 :
    //aaaa
    //Sample Output 2 :
    //a*a*a*a

    //method
    static String solve(String str, String ans, int i)
    {
        //base case
        if(i >= str.length()) return ans;

        //processing
        if(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) ans += str.charAt(i) + "*";
        else ans += str.charAt(i);

        return solve(str, ans, i+1);
    }
    public static void main(String[] args) {
        //taking string as input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        int n = str.length(); //length of string

        //function call for further processing of recursion passing str, ans, index
        String ans = solve(str, "", 0);
        System.out.println(ans);
    }

}
