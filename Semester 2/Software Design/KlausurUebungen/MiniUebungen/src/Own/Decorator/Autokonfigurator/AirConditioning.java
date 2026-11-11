package Own.Decorator.Autokonfigurator;

public class AirConditioning extends CarExtraDecorator {
    public AirConditioning(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return String.format("%s Klimaanlage", car.getDescription());
    }

    @Override
    public double getPrice() {
        return car.getPrice() + 1500;
    }
}
