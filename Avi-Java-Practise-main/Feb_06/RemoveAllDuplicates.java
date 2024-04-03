package Feb_06;

import java.util.Scanner;
import java.util.Stack;

public class RemoveAllDuplicates {

    static void solve(String str, Stack<Character> s, int i)
    {
        //base case
        if(i >= str.length()) return;

        //checking for first elements if they contain duplicates
        char ch = str.charAt(i);

        if(!s.isEmpty() && s.peek() == ch) s.pop();
        else {
            s.push(ch);
        }
         solve(str, s, i+1);

    }
    public static void main(String[] args) {
        //Recursively remove all adjacent duplicates
        //Given a string, recursively remove adjacent duplicate characters from the string. The output string should not have any adjacent duplicates. See the following examples.
        //
        //Examples:
        //
        //Input: azxxzy
        //Output: ay

        //taking string as input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        int n = str.length(); //length of string

        Stack<Character> s = new Stack<>();
        solve(str, s, 0);
        String ans = "";
        while(!s.isEmpty()){
            ans = s.pop() + ans;
        }
        System.out.println(ans);
    }
}
