package Own.Decorator.Autokonfigurator;

public class NavigationSystem extends CarExtraDecorator {
    public NavigationSystem(Car car) {
        super(car);
    }

    @Override
    public String getDescription() {
        return String.format("%s Navigationssystem", car.getDescription());
    }

    @Override
    public double getPrice() {
        return car.getPrice() + 800;
    }
}
