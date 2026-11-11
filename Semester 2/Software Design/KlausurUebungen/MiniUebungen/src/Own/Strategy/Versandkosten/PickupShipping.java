package Own.Strategy.Versandkosten;

import Own.Strategy.Versandkosten.singlefile.ShippingStrategy;

public class PickupShipping implements ShippingStrategy {
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
