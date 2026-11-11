package Own.Observer.WeatherStation;

public class Main {
    static void main(String[] args) {
        WindowDisplay window = new WindowDisplay();
        PhoneDisplay phone = new PhoneDisplay();

        WeatherStation weatherStation = new WeatherStation();

        weatherStation.registerObserver(window);
        weatherStation.registerObserver(phone);

        weatherStation.notifyObservers(30);

        weatherStation.removeObserver(window);
        weatherStation.notifyObservers(20);

        weatherStation.removeObserver(new WindowDisplay());
    }
}
