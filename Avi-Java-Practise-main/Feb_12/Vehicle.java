package Feb_12;

abstract class Vehicle {
    private String make;
    private String model;
    private int year;
    private double rentalPrice;

    Vehicle(String make, String model, int year, double rentalPrice)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public String getMake()
    {
        return make;
    }
    public String getModel()
    {
        return model;
    }
    public int getYear()
    {
        return year;
    }
    public double getRentalPrice()
    {
        return rentalPrice;
    }

    public abstract double calculateRentalCost(int days);
}
