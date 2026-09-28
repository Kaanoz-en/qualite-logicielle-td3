package cleancode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private final Map<LocalDateTime, Integer> reservedSeatsPerDay;
    private final List<Reservation> reservations;

    private static final int MINIMUM_OF_SEAT_PER_RESERVATION = 1;
    private static final int MINIMUM_RESERVATION_DELAY_IN_HOURS = 3;
    private static final int MAXIMUM_CAPACITY = 40;

    public Restaurant(){
        reservedSeatsPerDay = new HashMap<>();
        reservations = new ArrayList<>();
    }

    public String reserve(int numberOfSeats, String person, LocalDateTime datetime){
        if(isReservationInvalid(numberOfSeats, datetime)) {
            throw new ReservationInvalidException();
        }

        if (isCapacityReached(numberOfSeats, datetime)) {
            throw new CapacityReachedException();
        }

        updateReservedSeats(numberOfSeats, datetime);

        addReservation(numberOfSeats, person, datetime);

        return createConfirmation(person, datetime);
    }


    private String createConfirmation(String person, LocalDateTime datetime){
        return String.format("%s-%s-%s", person, reservations.size(), datetime.format(DateTimeFormatter.ofPattern("yyyyMMdd")));

    }

    private boolean isMinimumSeatPerReservation(int numberOfSeats){
        return numberOfSeats <= MINIMUM_OF_SEAT_PER_RESERVATION;
    }

    private boolean isMinimumReservationDelayRespected(LocalDateTime datetime){
        return datetime.isBefore(LocalDateTime.now().plusHours(MINIMUM_RESERVATION_DELAY_IN_HOURS));
    }

    private boolean isReservationInvalid(int numberOfSeats, LocalDateTime datetime){
        return isMinimumSeatPerReservation(numberOfSeats)|| isMinimumReservationDelayRespected(datetime);
    }

    private boolean isCapacityReached(int numberOfSeats, LocalDateTime datetime){
        int previousReservedSeats = getPreviouslyReservedSeats(datetime);
       return (MAXIMUM_CAPACITY - previousReservedSeats) < numberOfSeats;
    }

    private int getPreviouslyReservedSeats(LocalDateTime datetime){
        return reservedSeatsPerDay.getOrDefault(datetime,0);
    }

    private void updateReservedSeats(int numberOfSeats, LocalDateTime datetime){
        reservedSeatsPerDay.put(datetime, reservedSeatsPerDay.getOrDefault(datetime, 0) + numberOfSeats);
    }

    private void addReservation(int numberOfSeats, String person, LocalDateTime datetime){
        Reservation reservation = new Reservation(datetime, person, numberOfSeats);
        reservations.add(reservation);
    }
}

