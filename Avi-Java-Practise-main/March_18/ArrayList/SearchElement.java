package March_18.ArrayList;

import java.util.ArrayList;

public class SearchElement {
    public static void main(String[] args)
    {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("Red");
        arr.add("Green");
        arr.add("Orange");
        arr.add("White");

        String target = "Green";
        boolean isFound = false;

        for(int i=0; i<arr.size(); i++)
        {
            if(arr.get(i) == target) isFound = true;
        }

        System.out.println(isFound ? "Found" : "Not Found");
    }
}
