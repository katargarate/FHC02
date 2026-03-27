package Model;

public class Shop {
    private final String NAME;
    private final OpeningHours OPENING_HOURS;

    public Shop(String NAME, OpeningHours openingHours) {
        this.NAME = NAME;
        this.OPENING_HOURS= openingHours;
    }

    public String getNAME() {
        return NAME;
    }


    public OpeningHours getOPENING_HOURS() {
        return OPENING_HOURS;
    }
}
