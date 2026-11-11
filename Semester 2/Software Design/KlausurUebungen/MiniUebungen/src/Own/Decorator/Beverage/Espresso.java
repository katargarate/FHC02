package Own.Decorator.Beverage;

public class Espresso extends Beverage {

    @Override
    public float getCost() {
        return 2.5F;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
