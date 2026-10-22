namespace Module4.Task2;

// Aufgabe 2: Konstruktorverkettung
// Erweitere die Klasse ElectricCar um Eigenschaft EnergyConsumption, die den Verbrauch in kwh/100km
// angibt. Die Eigenschaft soll im Konstruktor initialisiert werden.
// Implementiere eine Konstruktorverkettung in ElectricCar, bei der ein Konstruktor ohne batteryCapacity
// und energyConsumption Parameter einen Standardwert für die Akkukapazität verwendet und dabei den
// anderen Konstruktor aufruft.
// Teste dies, indem du Instanzen von Car und ElectricCar mit verschiedenen Parametern erstellst.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        var electricCarFull = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0);
        var electricCarDefault = new ElectricCar("Black", "Bolt", 190);

        Console.WriteLine($"{car.Model}: {car.FuelEfficiency} L/100km");
        Console.WriteLine($"{electricCarFull.Model}: {electricCarFull.BatteryCapacity} kWh, " +
                           $"{electricCarFull.EnergyConsumption} kWh/100km");
        Console.WriteLine($"{electricCarDefault.Model}: {electricCarDefault.BatteryCapacity} kWh, " +
                           $"{electricCarDefault.EnergyConsumption} kWh/100km");
    }
}
