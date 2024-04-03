package Feb_15;

import java.util.*;

public class ReservationSystem {

    private List<Flight> flights;
    public ReservationSystem()
    {
        this.flights = new ArrayList<>();
    }

//add flight
    public void addFlight(Flight flight)throws ReservationException
    {
        if(flight.getAvailableSeats() > 0)
        {
            flights.add(flight);
            return;
        }
        throw new ReservationException("Invalid seat number. should be greater than zero");
    }

    //reserve flight
    public void reserveSeat(int flightNumber, int numberOfSeats) throws ReservationException
    {
        Flight flight = findFlight(flightNumber);
        flight.reserveSeat(numberOfSeats);
    }

    //cancel reservation
    public void cancelReservation(int flightNumber, int numberOfSeats) throws ReservationException
    {
        Flight flight = findFlight(flightNumber);
        flight.cancelReservation(numberOfSeats);
    }



    //find flight
    public Flight findFlight(int flightNumber) throws ReservationException
    {
        for(Flight flight: flights)
        {
            if(flight.getFlightNumber() == flightNumber) return flight;
        }
        throw new ReservationException("Flight number not found with flight number: " + flightNumber);
    }

}
