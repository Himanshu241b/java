package March_18.ArrayList;

import java.util.ArrayList;

public class IterateAllElements {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("Red");
        arr.add("Green");
        arr.add("Orange");
        arr.add("White");

        var iterator = arr.iterator();

        while(iterator.hasNext()) System.out.println(iterator.next());

    }
}
