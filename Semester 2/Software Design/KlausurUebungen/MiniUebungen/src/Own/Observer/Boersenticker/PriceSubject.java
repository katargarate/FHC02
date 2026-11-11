package Own.Observer.Boersenticker;

public interface PriceSubject {
    void registerObserver(PriceObserver o);
    void removeObserver(PriceObserver o);
}
