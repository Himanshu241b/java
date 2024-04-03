package Feb_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<Vehicle> rentedVehicles;

    Customer(String name, String email)
    {
        this.name = name;
        this.email = email;
        this.rentedVehicles = new ArrayList<>();
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public List<Vehicle> getRentedVehicles()
    {
        return rentedVehicles;
    }

    //rent a vehicle, adding to list
    public void rentVehicle(Vehicle vehicle)
    {
        rentedVehicles.add(vehicle);
    }

    //return a rented vehicle, remove from list
    public void  returnVehicle(Vehicle vehicle)
    {
        rentedVehicles.remove(vehicle);
    }
}
