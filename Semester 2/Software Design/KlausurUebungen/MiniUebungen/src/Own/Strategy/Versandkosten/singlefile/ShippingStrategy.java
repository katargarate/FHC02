package Own.Strategy.Versandkosten.singlefile;

import Own.Strategy.Versandkosten.PickupShipping;

public interface ShippingStrategy {
    double calculate(double weightKg);
}

class StandardShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightKg) {
        // pauschale
        return 4.9;
    }

    @Override
    public String toString() {
        return "Standard (always €4.90)";
    }
}

class PickupStrategy implements ShippingStrategy{
    @Override
    public double calculate(double weightKg) {
        // gratis
        return 0.00;
    }

    @Override
    public String toString() {
        return "Pickup (always €0.00)";
    }
}

class ExpressShipping implements ShippingStrategy {
    @Override
    public double calculate(double weightKg) {
        // 9.9 + 1.5 pro Kg
        return 9.9 + (1.5 * weightKg);
    }

    @Override
    public String toString() {
        return "Express Shipping (€9.90 + €1.50 per kg)";
    }
}

class Order {
    private Own.Strategy.Versandkosten.singlefile.ShippingStrategy shippingStrategy;
    private double weight;

    public Order(double weight) {
        // Die Versandart ist anfangs StandardShipping.
        shippingStrategy = new Own.Strategy.Versandkosten.StandardShipping();
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

class Main {
    static void main(String[] args) {
        Own.Strategy.Versandkosten.Order o1 = new Own.Strategy.Versandkosten.Order(10);

        System.out.printf("Cost for 10kg package with standard shipping (default): €%.2f\n", o1.getShippingCost());

        o1.setShippingStrategy(new Own.Strategy.Versandkosten.ExpressShipping());
        System.out.printf("Cost for 10kg package with express shipping: €%.2f\n", o1.getShippingCost());

        o1.setShippingStrategy(new PickupShipping());
        System.out.printf("Cost for 10kg package with pick up: €%.2f\n", o1.getShippingCost());
    }
}