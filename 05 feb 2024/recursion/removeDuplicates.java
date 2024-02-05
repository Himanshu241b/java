import java.util.*;
public class removeDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        System.out.println(removeDup(s, sb, 1));
    }
    public static String removeDup(String s, StringBuilder sb, int i) {
        if(i == s.length())
            return sb.toString();
        else if(s.charAt(i) != s.charAt(i-1))
            return removeDup(s, sb.append(s.charAt(i)), i+1);
        return removeDup(s, sb, i+1);
    }
}
