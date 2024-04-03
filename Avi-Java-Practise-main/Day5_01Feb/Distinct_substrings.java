package Day5_01Feb;

import java.util.Scanner;

public class Distinct_substrings {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string");
        String str = sc.nextLine();

        boolean isChange = false;

        int[] c1 = new int[26];
        for(int i=0; i<str.length(); i++) c1[str.charAt(i) - 'a']++;

        for(int i=0; i<26; i++)
        {
            if(c1[i] > 1 && str.length() <= 26-c1[i]) isChange = true;
        }

        System.out.println(isChange);
    }
}
