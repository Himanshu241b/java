import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Main class emplementation
public class CarRentalSystem {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        char choice;
        Customers customersObject = new Customers();
        Customer customer = null;
        RentalAgency agency = new RentalAgency();
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Register as a customer...");
            System.out.println("2. Rent a car...");
            System.out.println("3. Add a car to rental agency...");
            System.out.println("4. Add a bike to agency...");
            System.out.println("5. Return a vehicle...");
            System.out.println("6. Rent a bike...");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.next().charAt(0); // Read the first character of user input
            scanner.nextLine(); // consumes the nextline character
            switch (choice) {
                case '1':
                    System.out.println("Enter your name...");
                    String name = scanner.nextLine();
                    System.out.println("Enter your email...");
                    String email = scanner.nextLine();
                    customer = new Customer(name, email);
                    customersObject.addCustomer(customer);
                    System.out.println("User has been registered");
                    break;
                case '2':
                    System.out.println("Enter your email...");
                    String custEmail = scanner.nextLine();
                    Customer cust = customersObject.getCustomer(custEmail);
                    System.out.println("What vehicle you want");
                    String vehicleType = scanner.nextLine();
                    Vehicle vehicle = agency.getVehicle(vehicleType);
                    System.out.println("For how many days you want to rent");
                    int days = scanner.nextInt();
                    agency.rentVehicle(cust, vehicle, days);
                    customer.addVehicle(vehicle);
                    break;
                case '3':
                    System.out.println("Enter make of car");
                    String make = scanner.nextLine();
                    System.out.println("Enter model of car");
                    String model = scanner.nextLine();
                    System.out.println("Enter year of manufacturing");
                    int year = scanner.nextInt();
                    System.out.println("Enter rental price:");
                    double rentalPrice = scanner.nextDouble();
                    System.out.println("Enter number of seats");
                    int seats = scanner.nextInt();
                    System.out.println("Enter fuel type: ");
                    String fuelType = scanner.nextLine();
                    Vehicle car = new Car(make, model, year, rentalPrice, seats, fuelType);
                    agency.addVehicle(car);               
                    System.out.println("Car is added");                 
                    break;
                case '4':
                    System.out.println("Enter make of bike");
                    String makeOfBike = scanner.nextLine();
                    System.out.println("Enter model of bike");
                    String modelOfBike = scanner.nextLine();
                    System.out.println("Enter year of manufacturing");
                    int yearOfBike = scanner.nextInt();
                    System.out.println("Enter rental price:");
                    double rentalPriceOfBike = scanner.nextDouble();
                    System.out.println("Enter bike type: ");
                    String bikeType = scanner.nextLine();
                    Vehicle bike = new Bike(makeOfBike, modelOfBike, yearOfBike, rentalPriceOfBike, bikeType);
                    new RentalAgency().addVehicle(bike);    
                    System.out.println("Bike added successfully");
                    break;
                case '5':
                    System.out.println("Enter your email...");
                    String returnEmail = scanner.nextLine();
                    Customer returnCustomer = customersObject.getCustomer(returnEmail);
                    System.out.println("Enter model of vehicle to return:");
                    String returnModel = scanner.nextLine();
                    Vehicle returnVehical = returnCustomer.getVehicleByModel(returnModel);
                    agency.returnVehicle(returnCustomer, returnVehical);
                    break;
                case '6':
                    System.out.println("Enter your email...");
                    String bikeEmail = scanner.nextLine();
                    Customer bikeCustomer = customersObject.getCustomer(bikeEmail);
                    System.out.println("What vehicle you want");
                    String type = scanner.nextLine();
                    Vehicle Bike = agency.getVehicle(type);
                    System.out.println("For how many days you want to rent");
                    int daysForBike = scanner.nextInt();
                    agency.rentVehicle(bikeCustomer, Bike, daysForBike);
                    customer.addVehicle(Bike);
                    break;
                case '0':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    
            }
            
        } while (choice != '0');
        
        scanner.close();
    }
}



    
// Abstract class Vehicle
abstract class Vehicle {
    // Attributes
    private String make;
    private String model;
    private int year;
    private double rentalPrice;

    // Constructor
    public Vehicle(String make, String model, int year, double rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayDetails();

    // returns make of vehicle
    public String getMake() {
        return make;
    }
    //sets make of vehicle
    public void setMake(String make) {
        this.make = make;
    }
    // gets model number
    public String getModel() {
        return model;
    }
    //sets model number
    public void setModel(String model) {
        this.model = model;
    }
    //gets year of manufacture
    public int getYear() {
        return year;
    }
    //set year of manufacture
    public void setYear(int year) {
        this.year = year;
    }
    //get rentalprice
    public double getRentalPrice() {
        return rentalPrice;
    }
    //set rental price
    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

     // Abstract method to calculate the rental cost
     public abstract double calculateRentalCost(int days);

     // Abstract method to get type of vehicle
     public abstract String getType();
}

// Car class extending Vehicle
class Car extends Vehicle {
    // Specific attributes for Car
    private int numSeats;
    private String fuelType;
    private static String type = "car";
    // Constructor
    public Car(String make, String model, int year, double rentalPrice, int numSeats, String fuelType) {
        super(make, model, year, rentalPrice);
        this.numSeats = numSeats;
        this.fuelType = fuelType;
    }

    // Override displayDetails() method from Vehicle
    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Rental Price: $" + getRentalPrice() + " per day");
        System.out.println("Number of Seats: " + numSeats);
        System.out.println("Fuel Type: " + fuelType);
    }

    // Getters and setters for specific attributes
    public int getNumSeats() {
        return numSeats;
    }
    //overriden method to get type of vehicle
    @Override
    public String getType(){
        return type;
    }
    // method to set numbet of seats 
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    // get the fuel type of vehicle
    public String getFuelType() {
        return fuelType;
    }
    // to set fueltype of vehicle
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
     // Override calculateRentalCost() method for bikes
     @Override
     public double calculateRentalCost(int days) {
         // Implement specific calculation for bike rental cost
         double rentalCost = getRentalPrice() * days;
         // Add any specific calculations for bikes
         return rentalCost;
     }
}



// Bike class extending Vehicle
class Bike extends Vehicle {
    // Specific attributes for Bike
    private String bikeType; // Example: Sport, Cruiser, Touring
    private static String type = "bike";
    // Constructor
    public Bike(String make, String model, int year, double rentalPrice, String bikeType) {
        super(make, model, year, rentalPrice);
        this.bikeType = bikeType;
    }

    // Override displayDetails() method from Vehicle
    @Override
    public void displayDetails() {
        System.out.println("Bike Details:");
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Rental Price: $" + getRentalPrice() + " per day");
        System.out.println("Bike Type: " + bikeType);
    }

    // Getter and setter for specific attribute
    public String getBikeType() {
        return bikeType;
    }
    //to get type of vehicle
    public String getType(){
        return type;
    }
    // to set the type of bike
    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    // Override calculateRentalCost() method for bikes
    @Override
    public double calculateRentalCost(int days) {
        // Implement specific calculation for bike rental cost
        double rentalCost = getRentalPrice() * days;
        // Add any specific calculations for bikes
        return rentalCost;
    }
}
class Customers {
    static private List<Customer> customers = new ArrayList<Customer>();

    // adding customer to list of customers
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    // method to retur nthe customer from list of customers by searching with email
    public  Customer getCustomer(String email){
        for(Customer customer : customers)
            if(customer.getEmail().equals(email))
                return customer;
        System.out.println("Customer not fount");
        return null;
    }

    
}

// Customer class with encapsulated attributes
class Customer {
    
    private String name;
    private String email;
    private List<Vehicle> rentedVehicles;

    // Constructor
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.rentedVehicles = new ArrayList<>();
    }

    // add vehicle to rentedvehicle list
    public void addVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    // returns the vehicle search with model number
    public Vehicle getVehicleByModel(String model) {
        for (Vehicle vehicle: rentedVehicles)
            if(vehicle.getModel().equals(model))
                return vehicle;
        System.out.println("vehicle not found to return");
        return null;
    }
    //sets name of customer
    public void setName(String name) {
        this.name = name;
    }
    //gets email of customer
    public String getEmail() {
        return email;
    }
    // returns list of rented vehicles
    public List<Vehicle> getRentedVehicles() { 
        return rentedVehicles;
    }

    //sets the email
    public void setEmail(String email) {
        this.email = email;
    }

    // Method to add rented vehicle to the list
    public void rentVehicle(Vehicle vehicle) {
        rentedVehicles.add(vehicle);
    }

    // Method to display rented vehicles
    public void displayRentedVehicles() {
        System.out.println("Rented Vehicles for " + name + ":");
        for (Vehicle vehicle : rentedVehicles) {
            System.out.println(vehicle.getMake() + " " + vehicle.getModel());
        }
    }
}



// RentalAgency class with polymorphism
class RentalAgency {
    private static List<Vehicle> availableVehicles = new ArrayList<>();

    

    // Method to add available vehicles to the agency
    public void addVehicle(Vehicle vehicle) {
        availableVehicles.add(vehicle);
    }

    
    // method to get vehicle from available vehicles list
    public Vehicle getVehicle(String type){
        for(Vehicle vehicle : availableVehicles)
            if(vehicle.getType().equals(type))
                return vehicle;
        System.out.println("Vehicle not found");
        return null;
    }
    // Method to rent a vehicle
    public void rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (availableVehicles.contains(vehicle)) {
            availableVehicles.remove(vehicle);
            customer.rentVehicle(vehicle);
            double rentalCost = calculateRentalCost(vehicle, days);
            System.out.println(customer.getName() + " rented " + vehicle.getMake() + " " + vehicle.getModel() +
                    " for " + days + " days. Rental cost: ₹" + rentalCost);
        } else {
            System.out.println("Vehicle is not available for rent.");
        }
    }

   
    
    // Method to return a rented vehicle
    public void returnVehicle(Customer customer, Vehicle vehicle) {
        if (customer != null && customer.getName() != null && !customer.getName().isEmpty() &&
                customer.getEmail() != null && !customer.getEmail().isEmpty() &&
                customer.getRentedVehicles().contains(vehicle)) {
            customer.getRentedVehicles().remove(vehicle);
            availableVehicles.add(vehicle);
            System.out.println(vehicle.getMake() + " " + vehicle.getModel() + " has been returned by " + customer.getName());
        } else {
            System.out.println("Invalid customer or vehicle information.");
        }
    }

    // Method to calculate rental cost based on the type of vehicle
    private double calculateRentalCost(Vehicle vehicle, int days) {
        double rentalCost = vehicle.getRentalPrice() * days;
        // Adjust the rental cost based on the type of vehicle if needed
        if (vehicle instanceof Car) {
            rentalCost *= 0.95; // 5% discount for cars
        }
        return rentalCost;
    }
}




