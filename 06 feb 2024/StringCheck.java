import java.util.Scanner;

public class StringCheck {
    public static void main(String[] args) {
       
Scanner sc = new Scanner(System.in);
System.out.println("Entr the string");
String s = sc.next();
if(checkStringRules(s))
     System.out.println("true");
 else
     System.out.println("false");
    }

    public static boolean checkStringRules(String s) {
        // Base case: If the string is empty, return true
        if (s.isEmpty()) {
            return true;
        }

        // Case 1: If the string starts with 'a'
        if (s.charAt(0) == 'a') {
            // If the next character is 'a', 'b', or the string is just 'a', continue recursively
            if (s.length() >= 2 && (s.charAt(1) == 'a' || s.charAt(1) == 'b')) {
                return checkStringRules(s.substring(1));
            }
            // If the next characters are "bb", continue recursively
            else if (s.length() >= 2 && s.startsWith("bb", 1)) {
                return checkStringRules(s.substring(2));
            } else {
                return false;
            }
        }
        // Case 2: If the string starts with "bb"
        else if (s.startsWith("bb")) {
            // If the next character is 'a', continue recursively
            if (s.length() >= 3 && s.charAt(2) == 'a') {
                return checkStringRules(s.substring(2));
            }
            // If the rest of the string follows the rules, return true
            else {
                return checkStringRules(s.substring(2));
            }
        }
        // If the string doesn't start with 'a' or "bb", return false
        else {
            return false;
        }
    }
}
