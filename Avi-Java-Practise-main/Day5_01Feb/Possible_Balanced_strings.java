package Day5_01Feb;

import java.util.Scanner;
import java.util.Stack;

public class Possible_Balanced_strings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str = sc.nextLine();

        Stack<Character> s = new Stack<>();
        //open
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch == ')')
            {
                if(!s.isEmpty()) s.pop();
                else s.push(ch);
            }
            else
            {
                s.add(ch);
            }
        }
        System.out.println(s.size());
    }
}
