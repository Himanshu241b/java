package vehiclefactory;

/**
 * truck class implements vehicle interface
 */
public class Truck implements Vehicle{
    /**
     * method to manufacture a truck
     */
    @Override
    public void manufacture() {
        System.out.println("Truck is manufactured");
    }
}