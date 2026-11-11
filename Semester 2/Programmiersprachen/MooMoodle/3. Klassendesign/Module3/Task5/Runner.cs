namespace Module3.Task5;

// Aufgabe 5: Out-Parameter
// Erweitere die Klasse Car um Eigenschaft double FuelEfficiency (Liter pro 100km) die nach dem
// Initialisieren nicht änderbar sein sollte.
// Erweitere die Methode GetFuelLevel mit einem out double maxDistance Parameter. Berechne die maximale
// Strecke, die das Auto mit dem aktuellen Kraftstoffstand fahren kann.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0);

        double maxDistance;
        double fuelLevel = car.GetFuelLevel(out maxDistance);
        Console.WriteLine($"Fuel level: {fuelLevel} L, max distance: {maxDistance} km");
    }
}
