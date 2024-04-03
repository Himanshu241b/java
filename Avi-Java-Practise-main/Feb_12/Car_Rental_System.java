package Feb_12;



public class Car_Rental_System {
    public static void main(String[] args) {
        RentalAgency rentalAgency = new RentalAgency();

        Car car1 = new Car("Toyota", "Camry", 2020, 50.0, 5, "Petrol");
        Car car2 = new Car("Honda", "Civic", 2021, 60.0, 4, "Electric");

        rentalAgency.addVehicle(car1);
        rentalAgency.addVehicle(car2);

        Customer customer1 = new Customer("John Doe", "john.doe@example.com");

        rentalAgency.rentVehicle(customer1, car1, 3);

        // Display rented vehicles for the customer
        System.out.println(customer1.getName() + "'s rented vehicles:");
        for (Vehicle vehicle : customer1.getRentedVehicles()) {
            System.out.println(vehicle.getMake() + " " + vehicle.getModel());
        }

        // Return the rented vehicle
        rentalAgency.returnVehicle(customer1, car1);

        // Display available vehicles after returning
        System.out.println("Available vehicles after return:");
        for (Vehicle vehicle : rentalAgency.getAvailableVehicles()) {
            System.out.println(vehicle.getMake() + " " + vehicle.getModel());
        }
    }
}
