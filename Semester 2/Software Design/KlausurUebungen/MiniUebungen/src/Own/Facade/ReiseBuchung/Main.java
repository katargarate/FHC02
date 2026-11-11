package Own.Facade.ReiseBuchung;

public class Main {
    static void main(String[] args) {
        TravelFacade travelAgency = new TravelFacade();

        System.out.println("-- Full trip --");
        travelAgency.bookFullTrip("Milan", 5);

        System.out.println("\n\n-- Weekend trip --");
        travelAgency.bookWeekendTrip("Mallorca");

        // Hier vereinfacht die facade es für den Kunden, weil sie nur die TravelFacade kennen müssen, und alle andere Schritte
        // werden von der Own.Facade übernommen. Sie müssen sich nicht um den Hotel Booking oder Car Rental oder Flight booking kümmern
    }
}
