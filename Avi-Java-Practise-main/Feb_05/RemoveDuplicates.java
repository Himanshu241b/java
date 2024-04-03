package Feb_05;

import java.util.Scanner;

public class RemoveDuplicates {

    static StringBuilder solve(String str, StringBuilder res, int i)
    {
        //base case
        if(i >= str.length()){
            res.append(str.charAt(str.length()-1));
            return res;
        }

        if(i < str.length()-1 && str.charAt(i) != str.charAt(i+1)) res.append(str.charAt(i));
        solve(str, res, i+1);
        return res;
    }
    public static void main(String[] args) {
        //You are given a string ‘str’ of size ‘N’. Your task is to remove consecutive duplicates from this string recursively.

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String str = sc.next();
        int n = str.length();
        StringBuilder res = new StringBuilder();
        res = solve(str, res, 0);
        System.out.println(res);
    }
}
