package Model;

import java.time.DayOfWeek;

import static Model.OpeningVariations.MONTOFRI;
import static Model.OpeningVariations.TUETOFRI;
import static java.time.DayOfWeek.*;

public class OpeningHours {
    private final String OPENING_TIME  ;
    private final String CLOSING_TIME;
    private final OpeningVariations ov; // nutze den ENUM

    public OpeningHours(String OPENING_TIME, String CLOSING_TIME, OpeningVariations ov) {
        this.OPENING_TIME = OPENING_TIME;
        this.CLOSING_TIME = CLOSING_TIME;
        this.ov = ov;
    }

    public String getOpeningHoursToday(DayOfWeek dayOfWeek) {

        // if saturday or sunday OR were on tuetofri schedule -> return closed message
        if (dayOfWeek.equals(SATURDAY) || dayOfWeek.equals(SUNDAY) || (ov == TUETOFRI && dayOfWeek.equals(MONDAY))) {
            return "CLOSED TODAY";
        }

        // otherwise return the opening hours
        return String.format("Open from %s until %s", OPENING_TIME, CLOSING_TIME);

    }






}
