package Feb_06;

import java.util.Scanner;

public class String_with_a_b {

    //Suppose you have a string, S, made up of only 'a's and 'b's. Write a recursive function that checks if the string was generated using the following rules:
    //
    //a. The string begins with an 'a'
    //b. Each 'a' is followed by nothing or an 'a' or "bb"
    //c. Each "bb" is followed by nothing or an 'a'
    //If all the rules are followed by the given string, return true otherwise return false.
    //
    //Sample Input 1 :
    //abb
    //Sample Output 1 :
    //true
    //Sample Input 2 :
    //abababa
    //Sample Output 2 :
    //false


    //method
    static boolean solve(String str, int i)
    {
        //base case
        if(i == str.length()-1) return true;

        //processing
        //checking if a is followed by a or bb or nothing
        if(str.charAt(i) == 'a')
        {
            //if followed by a
            if(i+1 < str.length() && str.charAt(i+1) == 'a') return solve(str, i+1);
            //if followed by bb
            else if(i+2 < str.length() && str.charAt(i+1) == 'b' && str.charAt(i+2) == 'b'){
                return solve(str, i+2);
            }
        }

        //checking if bb is followed by a
        if(i+1 < str.length() && str.charAt(i) == 'b' && str.charAt(i+1) == 'b')
        {
            if(i+2 < str.length() && str.charAt(i+2) == 'a') return solve(str, i+2);
        }

        //if nothing matches
        return false;
    }

    public static void main(String[] args) {

        //taking string as input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        int n = str.length(); //length of string

        //function call for further processing of recursion passing str, index
        boolean ans = solve(str, 0);
        System.out.println(ans);
    }
}
