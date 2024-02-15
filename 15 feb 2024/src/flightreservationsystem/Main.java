package flightreservationsystem;

public class Main {
   public static void main(String[] args){
    try {
        // Create a new flight
        Flight flight1 = new Flight("F001", "New York", "London", 100);
        // Create a reservation system
        ReservationSystem reservationSystem = new ReservationSystem();
        // Add the flight to the reservation system
        reservationSystem.addFlight(flight1);
        // Reserve seats on the flight
        reservationSystem.reserve("F001", 3);
        // Cancel reservation on the flight
        reservationSystem.cancelReservation("F001", 1);
    } catch (ReservationException | InvalidSeatNumberException e) {
        e.printStackTrace();
    }
   }
}
