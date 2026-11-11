package Own.Strategy.Versandkosten;

import Own.Strategy.Versandkosten.singlefile.ShippingStrategy;

public class Order {
    private Own.Strategy.Versandkosten.singlefile.ShippingStrategy shippingStrategy;
    private double weight;

    public Order(double weight) {
        // Die Versandart ist anfangs StandardShipping.
        shippingStrategy = new StandardShipping();
        this.weight = weight;
    }

    public void setShippingStrategy(ShippingStrategy s) {
        shippingStrategy = s;
        System.out.println("\nThe shipping strategy has been set to: " + shippingStrategy);
    }

    public double getShippingCost() {
        // use the objects current shipping strategy to get the correct shipping cost
        return shippingStrategy.calculate(weight);
    }
}
