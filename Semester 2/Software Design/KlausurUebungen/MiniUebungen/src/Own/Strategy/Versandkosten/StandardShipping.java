package Own.Strategy.Versandkosten;

import Own.Strategy.Versandkosten.singlefile.ShippingStrategy;

public class StandardShipping implements ShippingStrategy {
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
