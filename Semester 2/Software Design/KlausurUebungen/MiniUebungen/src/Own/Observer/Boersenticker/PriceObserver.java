package Own.Observer.Boersenticker;

public interface PriceObserver {
    void update(String symbol, double price);
}
