package Feb_05.recursion;

import java.util.Scanner;

public class RemoveConsecutiveDuplicates {

    static StringBuilder solve(String str, StringBuilder ans, int i)
    {
        //base case
        if(i >= str.length()){
            ans.append(str.charAt(str.length()-1));
            return ans;
        }

        if(i < str.length()-1 && str.charAt(i+1) != str.charAt(i)) ans.append(str.charAt(i));

        return solve(str, ans, i+1);
    }
    public static void main(String[] args) {
        //Given a string S, remove consecutive duplicates from it recursively.

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string");
        String str = sc.next();
        int n = str.length();

        StringBuilder ans = new StringBuilder();
        System.out.println(solve(str, ans, 0));
    }
}
