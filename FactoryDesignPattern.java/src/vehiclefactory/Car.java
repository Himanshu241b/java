package vehiclefactory;

/**
 * Car class implements vehicle interface
 */
public class Car implements Vehicle{
    /**
     * Method to manufacture a car
     */
    @Override
    public void manufacture(){
        System.out.println("Car is manufactured");
    }
}