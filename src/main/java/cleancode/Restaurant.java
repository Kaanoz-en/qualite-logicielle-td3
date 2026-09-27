package cleancode;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
    private final Map<LocalDateTime, Integer> people;
    private final List<Reservation> res;

    public Restaurant(){
        people = new HashMap<>();
        res = new ArrayList<>();
    }

    public String reserve(int p, String n, LocalDateTime date){
        if(p>1 && date.isAfter(LocalDateTime.now().plusHours(3))) {
            if (40 - people.getOrDefault(date, 0) < p) {
                throw new RuntimeException("Not enough places available on that day!");
            }

            people.put(date, people.getOrDefault(date, 0) + p);

            res.add(new Reservation(date, n, p));

            //Return reservation confirmation id: {name}-{reservationNumber}-{dateOfReservation format yyyyMMdd}
            return String.format("%s-%s-%s", n, res.size(), date.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        }
        throw new RuntimeException("Reservation cannot be done!");
    }
}
