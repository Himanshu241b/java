package Feb_15;

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        Flight flight1 = new Flight(123, "CityA", "CityB", 50);
        Flight flight2 = new Flight(456, "CityC", "CityD", 100);

        try {
            reservationSystem.addFlight(flight1);
            reservationSystem.addFlight(flight2);

            reservationSystem.reserveSeat(123, 25);
            reservationSystem.reserveSeat(456, 75);

            // Simulate an error by attempting to reserve a seat on a fully booked flight
            reservationSystem.reserveSeat(123, 30);

        } catch (ReservationException e) {
            System.out.println("Exception caught: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
