package Own.Observer.WeatherStation;

public class WindowDisplay implements Observer{
    @Override
    public void update(float temperature) {
        System.out.println("Printing temperature from window display: " + temperature + " degrees.");
    }
}
