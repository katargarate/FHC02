package Own.Observer.Boersenticker;

public class Main {
    static void main(String[] args) {
        // Der Vorteil, dass der StockTicker nur das Interface PriceObserver kennt, ist, dass es sich nicht darum kümmern muss,
        // wer alles registriert ist und was sie mit den Informationen machen, die infos gehen nur an alle subscribers aus und das wars

        // Lose Kopplung: Der StockTicker kennt nur das Interface PriceObserver, nicht die konkreten Klassen.
        // Dadurch können neue Anzeigen hinzugefügt oder entfernt werden, ohne den StockTicker zu ändern.

        AlertSystem alertSystem = new AlertSystem(120);
        StockTicker stockTicker = new StockTicker();
        ChartDisplay chartDisplay = new ChartDisplay();

        stockTicker.registerObserver(chartDisplay);
        stockTicker.registerObserver(alertSystem);

        stockTicker.setPrice("RSW", 130);
        stockTicker.setPrice("RSW", 110);
    }
}
