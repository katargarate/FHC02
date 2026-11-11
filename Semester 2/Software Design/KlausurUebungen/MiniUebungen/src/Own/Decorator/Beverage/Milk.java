package Own.Decorator.Beverage;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public float getCost() {
        return beverage.getCost() + 0.3f;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Milk";
    }


}
