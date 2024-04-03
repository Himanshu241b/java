package Da4_31jan;

import java.util.Scanner;

public class Remove_consecutive_duplicates {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();
        StringBuilder ans = new StringBuilder();
        char prev = str.charAt(0);
        ans.append(prev);

        for(int i=1; i<str.length(); i++)
        {
            char curr = str.charAt(i);
            if(prev != curr){
                ans.append(curr);
                prev = curr;
            }
        }
        System.out.println(ans);
    }
}
