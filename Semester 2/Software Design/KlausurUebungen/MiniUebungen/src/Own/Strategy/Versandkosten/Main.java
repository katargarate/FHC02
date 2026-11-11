package Own.Strategy.Versandkosten;

public class Main {
    static void main(String[] args) {
        Order o1 = new Order(10);

        System.out.printf("Cost for 10kg package with standard shipping (default): €%.2f\n", o1.getShippingCost());

        o1.setShippingStrategy(new ExpressShipping());
        System.out.printf("Cost for 10kg package with express shipping: €%.2f\n", o1.getShippingCost());

        o1.setShippingStrategy(new PickupShipping());
        System.out.printf("Cost for 10kg package with pick up: €%.2f\n", o1.getShippingCost());
    }
}
