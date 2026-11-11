package Own.KlausurVorjahr.Beispiel2Spiel;

public class EventData {
    private String eventDescription;
    private String eventDataURL;

    public EventData(String eventDescription, String eventDataURL) {
        this.eventDescription = eventDescription;
        this.eventDataURL = eventDataURL;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDataURL() {
        return eventDataURL;
    }

    public void setEventDataURL(String eventDataURL) {
        this.eventDataURL = eventDataURL;
    }
}
