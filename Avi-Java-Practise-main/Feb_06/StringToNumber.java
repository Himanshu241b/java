package Feb_06;

import java.util.Scanner;

public class StringToNumber {
//    Write a recursive function to convert a given string into the number it represents.
//    That is input will be a numeric string that contains only numbers, you need to convert the string
//    into corresponding integer and return the answer.

    //method
    static int solve(String str, int ans, int i)
    {
        //base case
        if(i >= str.length()) return ans;

        //making the number and incrementing the i
        ans = (ans*10) + (int) (str.charAt(i++) - '0');

        return solve(str, ans, i);
    }
    public static void main(String[] args) {

        //taking string as input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        int n = str.length(); //length of string

        //function call for further processing of recursion passing str, ans, index
        int ans = solve(str, 0, 0);
        System.out.println(ans);

    }
}
