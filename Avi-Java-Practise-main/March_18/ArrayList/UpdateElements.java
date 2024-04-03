package March_18.ArrayList;

import java.util.ArrayList;

public class UpdateElements {

    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("Red");
        arr.add("Green");
        arr.add("Orange");
        arr.add("White");

        arr.set(1, "Black");
        System.out.println(arr);
    }
}
