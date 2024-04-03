package Feb_05.recursion;

import java.util.Scanner;

public class Remove_x_chars {
    //Given a string, compute recursively a new string where all 'x' chars have been removed.

    static StringBuilder solve(String str, StringBuilder ans, int i)
    {
        //base case
        if(i >= str.length()) return ans;

        if(str.charAt(i) != 'x') ans.append(str.charAt(i));

        return solve(str, ans, i+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string");
        String str = sc.next();
        int n = str.length();

        StringBuilder ans = new StringBuilder();
        System.out.println(solve(str, ans, 0));
    }
}
