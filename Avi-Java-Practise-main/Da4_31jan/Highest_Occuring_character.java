package Da4_31jan;
import java.io.*;
import java.util.*;

public class Highest_Occuring_character {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();

        int[] c = new int[26];

        for(int i=0; i<str.length(); i++) c[str.charAt(i) - 'a']++;

        int maxCh = 0;
        int maxChI = 0;
        for(int i=0; i<str.length(); i++)
        {
            if(c[i] > maxCh)
            {
                maxCh = c[i];
                maxChI = i;
            }
        }

        System.out.println((char)(maxChI+'a'));
    }
}
