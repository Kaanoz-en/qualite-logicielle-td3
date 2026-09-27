package cleancode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantTest {
    private static final int ANY_NB_PEOPLE_UNDER_40 = 5;
    private static final String ANY_NAME = "Bob";
    private static final LocalDateTime ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS = LocalDateTime.now().plusHours(4);
    private Restaurant restaurant;

    @BeforeEach
    public void CreerRestaurant(){
        restaurant = new Restaurant();
    }

    @Test
    public void givenNoPeople_whenReserve_thenThrowException(){
        Executable reserve = () -> restaurant.reserve(0, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);

        assertThrows(Exception.class, reserve);
    }

    @Test
    public void givenReservationDateTimeBeforeNow_whenReserve_thenThrowException(){
        LocalDateTime reservationDateTimeBeforeNow = LocalDateTime.now().minusHours(1);

        Executable reserve = () -> restaurant.reserve(ANY_NB_PEOPLE_UNDER_40, ANY_NAME, reservationDateTimeBeforeNow);

        assertThrows(Exception.class, reserve);
    }

    @Test
    public void givenReservationDateTimeInLessThan3Hours_whenReserve_thenThrowException(){
        LocalDateTime reservationDateTimeInLessThan3Hours = LocalDateTime.now().plusHours(2);

        Executable reserve = () -> restaurant.reserve(ANY_NB_PEOPLE_UNDER_40, ANY_NAME, reservationDateTimeInLessThan3Hours);

        assertThrows(Exception.class, reserve);
    }

    @Test
    public void givenMultipleReservations_whenReserveWithMorePeopleThanRemainingCapacity_thenThrowException(){
        restaurant.reserve(10, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);
        restaurant.reserve(10, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);
        restaurant.reserve(10, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);
        restaurant.reserve(5, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);
        int moreThanRemainingCapacity = 6;

        Executable reserve = () -> restaurant.reserve(moreThanRemainingCapacity, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);

        assertThrows(Exception.class, reserve);
    }

    @Test
    public void givenMultipleReservations_whenReserveWithLessPeopleThanRemainingCapacity_thenReturnConfirmationId(){
        restaurant.reserve(ANY_NB_PEOPLE_UNDER_40, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);
        String expectedConfirmationId = "Bob-2-" + ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String confirmationId = restaurant.reserve(ANY_NB_PEOPLE_UNDER_40, ANY_NAME, ANY_FUTUR_DATE_TIME_IN_MORE_THAN_THREE_HOURS);

        assertEquals(expectedConfirmationId, confirmationId);
    }

}