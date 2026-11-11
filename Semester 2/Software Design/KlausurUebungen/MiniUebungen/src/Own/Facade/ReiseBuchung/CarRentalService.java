package Own.Facade.ReiseBuchung;

public class CarRentalService {

    public void rentCar(String destination, int days) {
        System.out.printf("\nCar successfully rented for %d days to %s!", days, destination);
    }
}
