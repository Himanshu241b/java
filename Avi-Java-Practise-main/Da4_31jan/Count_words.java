package Da4_31jan;
import java.util.*;

public class Count_words {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();
        int count = 0;
        for(int i=0; i<str.length(); i++)
        {
            if(str.charAt(i) == ' ')
            {
                count++;
            }
        }
        System.out.println(++count);
    }
}
