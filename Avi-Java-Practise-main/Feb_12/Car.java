package Feb_12;

public class Car extends Vehicle{
    private int numSeats;
    private String fuelType;

    Car(String make, String model, int year, double rentalPrice, int numSeats, String fuelType)
    {
        super(make, model, year, rentalPrice);
        this.numSeats = numSeats;
        this.fuelType = fuelType;
    }
    public int getNumSeats()
    {
        return numSeats;
    }
    public String getFuelType()
    {
        return fuelType;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalPrice() * days;
    }

}
