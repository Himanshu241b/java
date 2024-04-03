package Feb_05.recursion;

import java.util.*;
import java.util.Stack;

public class reverseStack {

    static void solve(Stack<Integer> s)
    {
        //base case
        if(s.isEmpty()) {
            return;
        }

        int el = s.peek(); s.pop();

        solve(s);

        insertAtBottom(s, el);
    }
    static void insertAtBottom(Stack<Integer> s, int el)
    {
        //base case
        if(s.isEmpty()){
            s.push(el);
            return;
        }

        int top = s.pop();
        insertAtBottom(s, el);
        s.push(top);
    }
    public static void main(String[] args) {
        //Reverse a given stack of 'N' integers using recursion. You are required to make changes in the input parameter itself.
        //Note: You are not allowed to use any extra space other than the internal stack space used due to recursion

        //putting input values into stack
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        System.out.println("enter values for stack until -1");
        int n = 0;
        while(n != -1){
            n = sc.nextInt();
            if(n != -1) s.push(n);
        }

        System.out.println(s);

        solve(s);

        System.out.println(s);
    }
}
