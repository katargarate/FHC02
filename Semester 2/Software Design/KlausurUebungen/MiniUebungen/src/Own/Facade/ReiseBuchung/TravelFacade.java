package Own.Facade.ReiseBuchung;

public class TravelFacade {
    private CarRentalService carRentalService = new CarRentalService();
    private FlightService flightService = new FlightService();
    private HotelService hotelService = new HotelService();

    public void bookWeekendTrip( String destination) {
        flightService.bookFlight(destination);
        hotelService.bookHotel(destination, 2);
    }

    public void bookFullTrip(String destination, int days) {
        flightService.bookFlight(destination);
        hotelService.bookHotel(destination, days);
        carRentalService.rentCar(destination, days);
    }
}
