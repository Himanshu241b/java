import java.util.*;
public class removeX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = scanner.next();
        String res =  remove(s, "", 0);
        System.out.println(res);
    }
    public static String remove(String s, String ans, int i){
        if(i == s.length())
            return ans;
        if (s.charAt(i) != 'x' && s.charAt(i) != 'X')
            return remove(s, ans+s.charAt(i), i+1);
        return remove(s, ans, i+1);
         
    }
}
