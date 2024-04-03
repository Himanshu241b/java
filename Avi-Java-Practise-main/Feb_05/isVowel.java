package Feb_05;

import java.util.Scanner;

public class isVowel {
    public static void main(String[] args) {
        //You are given a string ‘str’ of even length. Your task is to find out if we divide the ‘str’ from the middle,
        // will both the substrings contain an equal number of vowels or not.

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string in even length only");
        String str = sc.next();
        int n = str.length();

        if(str.length()%2 != 0) System.out.println("Enter even length string only");
        else
        {
            int vowel1 = 0, vowel2 = 0;

            //for first half
            for(int i=0; i<n/2; i++)
            {
                char ch = str.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowel1++;
            }

            //for 2nd half
            for(int i=n/2+1; i<n; i++)
            {
                char ch = str.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') vowel2++;
            }

            if(vowel1 == vowel2) System.out.println("True");
            else System.out.println("False");
        }


    }
}
