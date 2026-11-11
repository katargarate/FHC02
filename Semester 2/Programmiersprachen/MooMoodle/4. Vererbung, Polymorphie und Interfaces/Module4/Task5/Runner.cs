namespace Module4.Task5;

// Aufgabe 5: Typuntersuchung und Typumwandlung
// Erweitere die Klasse Car um die Methode ReplaceFuelFilter(), die eine Meldung ausgibt, dass der
// Kraftstofffilter ersetzt wurde.
// Erweitere die Klasse ElectricCar um die Methode CheckBatteryHealth(), die eine Meldung ausgibt, dass
// die Batterie überprüft wurde.
// Erstelle eine Methode MaintainVehicle(Vehicle vehicle) in der Program Klasse, die zuerst überprüft, ob
// das übergebene Objekt vom Typ Car oder ElectricCar ist. Rufe dann die spezifischen Methoden
// (ReplaceFuelFilter, oder CheckBatteryHealth) auf.
// Teste dies, indem du sowohl ein Car als auch ein ElectricCar erstellst und diese der Methode
// MaintainVehicle übergibst.
static class Runner
{
    // Plays the role of the "Program" class' MaintainVehicle method for this task.
    private static void MaintainVehicle(Vehicle vehicle)
    {
        if (vehicle is Car)
        {
            Car car = (Car)vehicle;
            car.ReplaceFuelFilter();
        }
        else if (vehicle is ElectricCar)
        {
            ElectricCar electricCar = (ElectricCar)vehicle;
            electricCar.CheckBatteryHealth();
        }
    }

    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0);

        MaintainVehicle(car);
        MaintainVehicle(electricCar);
    }
}
