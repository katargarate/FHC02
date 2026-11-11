package Own.Decorator.Beverage;

public class Caramel extends CondimentDecorator {

    public Caramel(Beverage beverage) {
        super(beverage);
    }

    @Override
    public float getCost() {
        return beverage.getCost() + 0.5f;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " Caramel";
    }


}
