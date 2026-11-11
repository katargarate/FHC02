package Own.Facade.ReiseBuchung;

public class HotelService {

    public void bookHotel(String destination, int nights) {
        System.out.printf("\nHotel in %s successfully booked for %d nights!", destination, nights);
    }
}
