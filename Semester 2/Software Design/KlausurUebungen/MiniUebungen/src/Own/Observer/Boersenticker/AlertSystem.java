package Own.Observer.Boersenticker;

public class AlertSystem implements PriceObserver {
    private double limit;

    public AlertSystem(double limit) {
        this.limit = limit;
    }

    @Override
    public void update(String symbol, double price) {
        if (price < limit) {
            System.out.println("Msg to Alert System: Symbol: " + symbol + ", Price: " + price);
        }
    }
}
