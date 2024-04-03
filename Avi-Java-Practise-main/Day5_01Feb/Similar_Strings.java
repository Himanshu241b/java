package Day5_01Feb;

import java.util.Scanner;

public class Similar_Strings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str = sc.nextLine();

        System.out.println("Enter the 2nd string");
        String str2 = sc.nextLine();
        //String ‘A’ is said to be similar to string ‘B’ if and only if
        //1. ‘A’ is equal to ‘B’.
        //2. Divide both ‘A’ and ‘B’ into two – two strings ‘A1’, ‘A2’ , ‘B1’ and ‘B2’ such that both of them('A1' and 'A2') have same size. Then at least one of the following must hold true:
        //   a. ‘A1’ is similar to ‘B1’ and ‘A2’ is similar to ‘B2’.
        //   b. ‘A1’ is similar to ‘B2’ and ‘A2’ is similar to ‘B1’.

        boolean equal = true, halfEq = false;

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int i=0; i<str.length(); i++) c1[str.charAt(i) - 'a']++;
        for(int i=0; i<str2.length(); i++) c2[str2.charAt(i) - 'a']++;

        //checking equality
        for(int i=0; i<26; i++)
        {
            if(c1[i] != c2[i]) {
                equal = false;
                break;
            }
        }

        //dividing it into half
        String a1 = str.substring(0, str.length()/2);
        String a2 = str.substring(str.length()/2, str.length());
        System.out.println(a1 + " " + a2);

        String b1= str2.substring(0, str2.length()/2);
        String b2= str2.substring(str2.length()/2, str2.length());
        System.out.println(b1 + " " + b1);

        if((a1.equals(b1) && a2.equals(b2)) || (a1.equals(b2) && a2.equals(b1))) halfEq = true;

        if(equal && halfEq) System.out.println("Yes the strings are similar");
        else System.out.println("No the strings are not similar");

    }
}
