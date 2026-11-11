package Own.Observer.Boersenticker;

public class ChartDisplay implements PriceObserver {
    @Override
    public void update(String symbol, double price) {
        System.out.println("Msg to Chart Display: Symbol: " + symbol + ", Price: " + price);
    }
}
