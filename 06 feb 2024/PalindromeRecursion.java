import java.util.Scanner;
public class PalindromeRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the String to test:");
        String s = sc.next(); // take input
        if(isPalindrome(s, 0, s.length()-1))     //when it return true
            System.out.println("String is Palindrome");
        else                    
            System.out.println("Not a Palindrome");     //when it return false
    }
    public static boolean isPalindrome(String s, int i, int j) {
        if(s == null) // when string is empty or null
            return false;
        else if (j+1 == 1) // when length of string is 1 return true
            return true;
        if(s.charAt(i) != s.charAt(j))  //when characters dont mj+1 == 0atch
            return false;
        if(i == j)  // when i == j means all characters match return true
            return true;
        return isPalindrome(s, i+1, j-1); // recursively call for i+1 and j-1 index
            
    }
}
