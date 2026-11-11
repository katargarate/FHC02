package Own.Decorator.Autokonfigurator;

public class HeatedSeats extends CarExtraDecorator {
    public HeatedSeats(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return String.format("%s Sitzheizung", car.getDescription());
    }

    @Override
    public double getPrice() {
        return car.getPrice() + 600;
    }
}
