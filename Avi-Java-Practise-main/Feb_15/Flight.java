package Feb_15;

public class Flight {
    private int flightNumber;
    private String departureCity;
    private String destinationCity;
    private int availableSeats;

    public Flight(int flightNumber, String departureCity, String destinationCity, int availableSeats)
    {
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
    }

    //getters
    public int getFlightNumber()
    {
        return flightNumber;
    }
    public String getDepartureCity()
    {
        return departureCity;
    }
    public String getDestinationCity()
    {
        return destinationCity;
    }
    public int getAvailableSeats()
    {
        return availableSeats;
    }

    //reserve seat
    public void reserveSeat(int numberOfSeats) throws ReservationException
    {
        if(numberOfSeats > 0 && numberOfSeats <= availableSeats)
        {
            availableSeats -= numberOfSeats;
        }
        else if(availableSeats == 0) throw new ReservationException("Flight " + flightNumber + " has no availble seats.");
        else throw new InvalidSeatNumberException();
    }

    //cancel reservation
    public void cancelReservation(int numberOfSeats) throws ReservationException
    {
        if(numberOfSeats > 0)
        {
            availableSeats += numberOfSeats;
        }
        else if(availableSeats == 100) throw new ReservationException("No reservations have been made for this seat.");
        else throw new InvalidSeatNumberException();
    }


}
