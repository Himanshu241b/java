package Da4_31jan;

import java.util.ArrayList;
import java.util.Scanner;

public class All_substrings {

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();
        ArrayList<String> a = new ArrayList<>();

        for(int i=0; i<str.length(); i++)
        {
            for(int j=i; j<str.length(); j++)
            {
                a.add(str.substring(i, j+1));
            }
        }

        for(String i: a) System.out.println(i);
    }
}
