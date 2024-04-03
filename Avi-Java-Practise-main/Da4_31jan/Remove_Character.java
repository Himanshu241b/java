package Da4_31jan;

import java.util.Scanner;

public class Remove_Character {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();

        System.out.println("Enter the character");
        char x = sc.next().charAt(0);

//        for(int i=0; i<str.length(); i++)
//        {
//            char ch = str.charAt(i);
//            if(ch == x) str.replace(ch, x)
//        }
        System.out.println(str.replace(String.valueOf(x), ""));
    }
}
