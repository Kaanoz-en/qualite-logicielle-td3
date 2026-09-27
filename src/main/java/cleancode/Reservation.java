package cleancode;

import java.time.LocalDateTime;

public class Reservation {
    private LocalDateTime dateTime;
    private String name;
    private int peopleNumber;

    public Reservation(LocalDateTime dateTime, String name, int peopleNumber) {
        this.dateTime = dateTime;
        this.name = name;
        this.peopleNumber = peopleNumber;
    }
}
