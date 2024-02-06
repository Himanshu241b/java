import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the String to test:");
        String s = sc.next(); // take input
        System.out.println(remove(s));
    }
    public static String remove(String s) {
        
            StringBuilder sb = new StringBuilder();
    
            int i = 0;
            int n = s.length();
            while (i < n) {
                // Check if the current character is equal to the next character
                if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                    // Skip both characters and move to the next non-duplicate character
                    char currentChar = s.charAt(i);
                    while (i < n && s.charAt(i) == currentChar) {
                        i++;
                    }
                } else {
                    // Add the current character to the result
                    sb.append(s.charAt(i));
                    i++;
                }
            }
    
            // Recur on the remaining string if it has changed
            String newString = sb.toString();
            if (!newString.equals(s)) {
                return remove(newString);
            } else {
                return newString;
            }
        
        }
}
