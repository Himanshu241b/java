import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;
class possiblebalancedstrings { 
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string:");
        String A = scanner.next();
        String balancedString = parenthesisbalanced(A);
        System.out.println("balanced string:"+balancedString);
        System.out.println("removed length:"+(A.length()-balancedString.length()));
    }
    public static String parenthesisbalanced(String s){
        Deque<Integer> stack = new ArrayDeque<>(); // unpaired '(' indices
    StringBuilder sb = new StringBuilder(s);

    for (int i = 0; i < s.length(); ++i)
      if (sb.charAt(i) == '(') {
        stack.push(i); // Record the unpaired '(' index.
      } else if (sb.charAt(i) == ')') {
        if (stack.isEmpty())
          sb.setCharAt(i, '#'); // Mark the unpaired ')' as '#'.
        else
          stack.pop(); // Find a pair!
      }

    // Mark the unpaired '(' as '#'.
    while (!stack.isEmpty())
      sb.setCharAt(stack.pop(), '#');

    return sb.toString().replaceAll("#", "");
    }
}