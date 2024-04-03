package Feb_12;

import java.util.*;

public class RentalAgency {

    private List<Vehicle> availableVehicles;

    public RentalAgency() {
        this.availableVehicles = new ArrayList<>();
    }

    // Method to add available vehicles
    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
    }

    // Method to rent a vehicle
    public void rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (availableVehicles.contains(vehicle)) {
            availableVehicles.remove(vehicle);
            customer.rentVehicle(vehicle);
            System.out.println("Vehicle rented successfully!");
            System.out.println("Rental cost: $" + vehicle.calculateRentalCost(days));
        } else {
            System.out.println("Vehicle not available for rent.");
        }
    }

    // Method to return a rented vehicle
    public void returnVehicle(Customer customer, Vehicle vehicle) {
        if (customer.getRentedVehicles().contains(vehicle)) {
            availableVehicles.add(vehicle);
            customer.returnVehicle(vehicle);
            System.out.println("Vehicle returned successfully!");
        } else {
            System.out.println("You did not rent this vehicle from our agency.");
        }
    }

    public List<Vehicle> getAvailableVehicles()
    {
        return availableVehicles;
    }
}
