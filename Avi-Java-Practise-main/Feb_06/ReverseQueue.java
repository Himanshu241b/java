package Feb_06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {

    static void solve(Queue<Integer> q, int n)
    {
        //base case
        if(q.isEmpty()) return;

        //processing
        int top = q.remove();

        solve(q, n);

        q.add(top);
    }
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        //taking input in queue from user
        Queue<Integer> q = new LinkedList<>();

        System.out.println("Determine the size of Queue");
        int n = sc.nextInt();

        System.out.println("Provide the elements to add in queue");
        while(n > 0)
        {
            q.add(sc.nextInt());
            n--;
        }

        //function call
        solve(q, n);
        System.out.println(q);
    }
}
