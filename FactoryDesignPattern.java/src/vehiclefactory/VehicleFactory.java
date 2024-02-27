package vehiclefactory;

/**
 * vehicle factory to create a certain type of vehicle
 */
public class VehicleFactory{
    /**
     * factory method creates the vehicle of perticular type and returns its instance
     * @param type type of vehicle to be created
     * @return instance of specific type of vehicle
     */
    public Vehicle createVehicleObject(String type){
        if(type.equalsIgnoreCase("car"))
            return new Car();
        else if(type.equalsIgnoreCase("truck"))
            return new Truck();
        return null;
    }
}
