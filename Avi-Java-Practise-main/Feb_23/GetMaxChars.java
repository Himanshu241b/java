package Feb_23;

import java.util.*;
import java.util.Scanner;

public class GetMaxChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map<Character, Integer> m = new HashMap<>();

        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            if(!m.containsKey(ch)) m.put(ch, 1);
            else m.put(ch, m.get(ch)+1);
        }
        int maxi = 0;
        char maxChar = '0';
        for(Map.Entry<Character, Integer> i: m.entrySet())
        {
            if(i.getValue() > maxi)
            {
                maxi = i.getValue();
                maxChar = i.getKey();
            }
        }
        System.out.println(maxChar);
    }
}
