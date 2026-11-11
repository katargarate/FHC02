package Own.Decorator.Autokonfigurator;

public class BasicCar extends Car {
    @Override
    public String getDescription() {
        return "Basis-Auto";
    }

    @Override
    public double getPrice() {
        return 20000;
    }
}
