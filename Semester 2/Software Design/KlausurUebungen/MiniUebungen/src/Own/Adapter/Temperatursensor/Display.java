package Own.Adapter.Temperatursensor;

public class Display {
    public void show(TemperatureSensor sensor) {
        System.out.println("Temperature in celsius: " + sensor.getCelsius());
    }
}
