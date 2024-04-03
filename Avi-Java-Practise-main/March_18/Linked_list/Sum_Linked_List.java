package March_18.Linked_list;

import java.util.Collections;
import java.util.LinkedList;


public class Sum_Linked_List {

    public static void main(String[] args)
    {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(4);
        l2.add(5);

        LinkedList<Integer> res = new LinkedList<>();

        Collections.reverse(l1);
        Collections.reverse(l2);

        int carry = 0;
        while(!l1.isEmpty() || !l2.isEmpty())
        {
            int digit1 = l1.isEmpty() ? 0 : l1.removeFirst();
            int digit2 = l2.isEmpty() ? 0 : l2.removeFirst();

            int sum = digit1 + digit2 + carry;

            carry = sum / 10;

            res.addFirst(sum % 10);
        }

        if(carry > 0) res.addFirst(1);

        System.out.println(res);
    }

}
