package Da4_31jan;

import java.util.Scanner;

public class String_palindrome {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();

        int i=0, j=str.length()-1;
        boolean flag = false;

        while(i < str.length() && j >=0 && i < j)
        {
            if(str.charAt(i++) != str.charAt(j--)){
                System.out.println("It is not a palindrome");
                flag = true;
                break;
            }
        }
        if(!flag) System.out.println("It is a palindrome");
    }
}
