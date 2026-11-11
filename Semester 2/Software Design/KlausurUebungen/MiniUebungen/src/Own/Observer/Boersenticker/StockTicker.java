package Own.Observer.Boersenticker;

import java.util.ArrayList;

public class StockTicker implements PriceSubject {
    ArrayList<PriceObserver> observers = new ArrayList<PriceObserver>();

    public void setPrice(String symbol, double price) {
        notifyObservers(symbol, price);
    }

    public void notifyObservers(String symbol, double price) {
        for (PriceObserver o : observers) {
            o.update(symbol, price);
        }
    }

    @Override
    public void registerObserver(PriceObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(PriceObserver o) {
        if (observers.contains(o)) {
            observers.remove(o);
        } else System.out.println("No such observer registered");
    }
}
