package March_18.ArrayList;

import java.util.ArrayList;

public class RetreiveElements {

    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("Red");
        arr.add("Green");
        arr.add("Orange");
        arr.add("White");
        arr.add("Black");

        for(int i=0; i<arr.size(); i++)
        {
            System.out.println(arr.get(i));
        }

    }
}
