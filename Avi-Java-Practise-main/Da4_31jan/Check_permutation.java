package Da4_31jan;

import java.util.Scanner;

public class Check_permutation {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();

        System.out.println("Enter the 2nd sentence");
        String str2 = sc.nextLine();

        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            c1[ch - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            c2[ch - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < 26; i++)
        {
            if(c1[i] != c2[i]) {
                flag = false;
            }
        }

        if(flag) System.out.println(true);
        else System.out.println(false);
    }
}