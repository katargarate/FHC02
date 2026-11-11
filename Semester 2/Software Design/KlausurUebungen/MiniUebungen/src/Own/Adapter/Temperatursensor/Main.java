package Own.Adapter.Temperatursensor;

public class Main {
    static void main(String[] args) {
        NewSensor newSensor = new NewSensor(12);
        OldThermometer oldThermometer = new OldThermometer(30);
        ThermometerAdapter thermometerAdapter = new ThermometerAdapter(oldThermometer);

        Display display = new Display();

        System.out.println("-- New sensor --");
        display.show(newSensor);
        System.out.println("-- Thermometer adapter --");
        display.show(thermometerAdapter);

        // Own.Adapter, weil eine einzelne inkompatible Klasse (OldThermometer) an das vom Client erwartete
        // Interface (TemperatureSensor) angepasst werden muss. Die Own.Facade würde dagegen mehrere Klassen
        // hinter einer einfachen Schnittstelle verstecken.
    }
}
