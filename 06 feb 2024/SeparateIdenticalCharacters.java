import java.util.Scanner;
public class SeparateIdenticalCharacters {
    static String ans = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the String to test:");
        String s = sc.next(); // take input
        System.out.println(separateChars(s, 0)+s.charAt(s.length()-1)); // returned string appended by the last character of string
    }
    public static String separateChars(String s, int i) {
        if(i == s.length()-1)
            return ans;
        else if(s.charAt(i) == s.charAt(i+1))
            ans = ans+s.charAt(i)+"*"; // if elements are equal append it along with *
        else 
             ans = ans+s.charAt(i); // if elements are not equal append the element
        return separateChars(s, i+1); // recursive call for next index 
    }
}
