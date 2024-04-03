package Feb_06;

import java.util.Scanner;

public class PlindromeString {

    static void solve(String str, int i, int j)
    {
        //base case
        if(i >= j) {
            System.out.println("Yes the string is palindrome");
            return;
        }

        //processing
        //checking if any of the pointers don't match
        if(str.charAt(i++) != str.charAt(j--))
        {
            System.out.println("No, the string is not palindrome");
            return;
        }
        solve(str, i, j); //recursive call
    }
    public static void main(String[] args) {
        //Determine if a given string ‘S’ is a palindrome using recursion.
        //Return a Boolean value of true if it is a palindrome and false if it is not.

        //taking string as input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        int n = str.length();

        // function call -> using 2 pointer approach, traversing it to half
        // and check if each string match or not
        solve(str, 0, n-1);
    }
}
