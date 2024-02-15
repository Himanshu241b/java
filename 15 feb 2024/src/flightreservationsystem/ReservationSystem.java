package flightreservationsystem;

// imports
import java.util.*;
// Reservation System class managing flights and reservations
class ReservationSystem {
    private Map<String, Flight> flights;

    public ReservationSystem() {
        flights = new HashMap<>();
    }

    // Add a new flight
    public void addFlight(Flight flight) throws ReservationException {
        if (flight.getAvailableSeats() < 0) {
            throw new ReservationException("Invalid number of available seats.");
        }

        flights.put(flight.getFlightNumber(), flight);
    }

    // Reserve seats on a flight
    public void reserve(String flightNumber, int seats) throws ReservationException, InvalidSeatNumberException {
        Flight flight = flights.get(flightNumber);
        if (flight == null) {
            throw new ReservationException("Flight does not exist.");
        }

        flight.reserveSeat(seats);
    }

    // Cancel reservation on a flight
    public void cancelReservation(String flightNumber, int seats) throws ReservationException, InvalidSeatNumberException {
        Flight flight = flights.get(flightNumber);
        if (flight == null) {
            throw new ReservationException("Flight does not exist.");
        }

        flight.cancelReservation(seats);
    }
}
