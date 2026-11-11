package Own.Observer.WeatherStation;

public class PhoneDisplay implements Observer{
    @Override
    public void update(float temperature) {
        System.out.println("Printing temperature from phone display: " + temperature + " degrees.");
    }
}
