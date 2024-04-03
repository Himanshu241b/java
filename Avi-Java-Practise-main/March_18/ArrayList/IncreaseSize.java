package March_18.ArrayList;

import java.util.ArrayList;

public class IncreaseSize {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Add some elements to the ArrayList
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // Print the original size of the ArrayList
        System.out.println("Original size of ArrayList: " + arrayList.size());

        // Increase the size of the ArrayList
        int newSize = 10;
        for (int i = arrayList.size(); i < newSize; i++) {
            arrayList.add(0); // Adding zeros as example elements
        }

        // Print the new size of the ArrayList
        System.out.println("New size of ArrayList: " + arrayList.size());

        // Print the elements of the ArrayList
        System.out.println("Elements of ArrayList: " + arrayList);
    }
}
