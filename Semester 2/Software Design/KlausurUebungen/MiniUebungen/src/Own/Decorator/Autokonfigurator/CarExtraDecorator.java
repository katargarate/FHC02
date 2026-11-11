package Own.Decorator.Autokonfigurator;

public abstract class CarExtraDecorator extends Car {
    protected Car car;

    public CarExtraDecorator(Car car) {
        this.car = car;
    }
}
