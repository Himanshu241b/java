package March_18.Linked_list;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Remove_duplicates
{
    public static void main(String[] args)
    {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(3);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(2);
        l.add(3);

        HashSet<Integer> s = new HashSet<>();

        var iterator = l.iterator();
        while(iterator.hasNext())
        {
            Integer num = iterator.next();
            if(s.contains(num))
            {
                iterator.remove();
            }
            else s.add(num);
        }
        System.out.println(l);
    }
}
