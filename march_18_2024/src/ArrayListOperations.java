import java.util.ArrayList;

class ArrayListOperations{
    public static void main(String[] args){
        ArrayList<String> colors = new ArrayList<String>(5);
        //insert data in colors
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("white");
        colors.add("black");

        // iterate throught the colors
        for(String color : colors)
            System.out.println(color);

        // retrieve a specific element at index 0
        System.out.println("element at index 0");
        System.out.println(colors.get(0));
        // retrieve a specific element at index 2
        System.out.println("element at index 2");
        System.out.println(colors.get(2));

        // update an element by a given element
        colors.set(2, "yellow");
        System.out.println("when 3rd element replaced by yellow ");
        for(String color : colors)
            System.out.println(color);

        // remove 3rd element from list
        colors.remove(2);
        System.out.println("list after removal");
        for(String color : colors)
            System.out.println(color);

        // search an element in list
        String searchElement = "Red";
        for(String color : colors){
            if(color.equals(searchElement))
                System.out.println("Element found");
        }

        // increase the size of list
        colors.add("yellow");
        System.out.println("list size: "+colors.size()+ " list capacity "+ getCapacity(colors));
        // add an element so it dynamically increases its size
        colors.add("Violet");
        System.out.println("list size after another insertion");
        System.out.println("list size: "+colors.size()+ " list capacity "+ getCapacity(colors));

        //trim the list
        colors.trimToSize();

        System.out.println("Size after trimming: " + colors.size());
        System.out.println("Capacity after trimming: " + getCapacity(colors));


    }

    // Helper method to get the capacity of an ArrayList using reflection
    private static int getCapacity(ArrayList<?> list) {
        try {
            java.lang.reflect.Field field = ArrayList.class.getDeclaredField("elementData");
            field.setAccessible(true);
            Object[] elementData = (Object[]) field.get(list);
            return elementData.length;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        }
    }
}