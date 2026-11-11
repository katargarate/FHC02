package Own.Strategy.Versandkosten;

import Own.Strategy.Versandkosten.singlefile.ShippingStrategy;

public class ExpressShipping implements ShippingStrategy {
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
