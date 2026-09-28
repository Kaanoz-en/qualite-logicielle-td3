package cleancode;

public class ReservationInvalidException extends RuntimeException {
    public ReservationInvalidException() {
        super("Reservation cannot be done!");
    }
}
