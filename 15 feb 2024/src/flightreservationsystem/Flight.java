package flightreservationsystem;

// Flight class representing a flight
class Flight {
    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private int availableSeats;

    public Flight(String flightNumber, String departureCity, String destinationCity, int availableSeats) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Reserve a seat on the flight
    public void reserveSeat(int seats) throws ReservationException, InvalidSeatNumberException {
        if (seats <= 0) {
            throw new InvalidSeatNumberException("Invalid number of seats.");
        }

        if (seats > availableSeats) {
            throw new ReservationException("Not enough available seats on the flight.");
        }

        availableSeats -= seats;
    }

    // Cancel a reservation on the flight
    public void cancelReservation(int seats) throws InvalidSeatNumberException {
        if (seats <= 0) {
            throw new InvalidSeatNumberException("Invalid number of seats.");
        }

        availableSeats += seats;
    }
}

