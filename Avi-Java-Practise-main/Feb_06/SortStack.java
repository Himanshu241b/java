package Feb_06;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {

    static void solve(Stack<Integer> s)
    {
        //base case
        if(s.isEmpty()) return;

        //processing
        int top = s.peek(); s.pop();
        solve(s);
        insertAtRightPos(s, top);
    }
    static void insertAtRightPos(Stack<Integer> s, int top)
    {
        //base case
        if(s.isEmpty()){
            s.push(top);
            return;
        }
        if(s.peek() < top)
        {
            s.push(top);
            return;
        }

        int pk = s.pop();
        insertAtRightPos(s, top);
        s.push(pk);
    }
    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of stack");
        int n = sc.nextInt();

        //input in stack by user
        System.out.println("Provide elements of stack");
        while(n>0)
        {
            s.push(sc.nextInt());
            n--;
        }

        solve(s);
        System.out.println(s);

    }
}
