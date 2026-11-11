package Own.Adapter.Temperatursensor;

public class OldThermometer {
    private int fahrenheit;

    public OldThermometer(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int readFahrenheit() {
        return fahrenheit;
    }
}
