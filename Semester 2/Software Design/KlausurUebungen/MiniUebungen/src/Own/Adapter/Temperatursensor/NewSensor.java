package Own.Adapter.Temperatursensor;

public class NewSensor implements TemperatureSensor {
    private double celsius;

    public NewSensor(double celcius) {
        this.celsius = celcius;
    }

    @Override
    public double getCelsius() {
        return celsius;
    }


}
