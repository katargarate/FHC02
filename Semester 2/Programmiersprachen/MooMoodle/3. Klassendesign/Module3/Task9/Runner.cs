namespace Module3.Task9;

// Aufgabe 9: Statische Mitglieder
// Füge ein statisches Feld int _carCount hinzu, das die Gesamtanzahl der erstellten Car-Objekte verfolgt.
// Erhöhe diesen Zähler in jedem Konstruktor.
// Erstelle eine statische Methode GetCarCount(), die die Anzahl der erstellten Autos zurückgibt. Teste
// dies, indem du mehrere Car-Objekte erstellst und GetCarCount() aufrufst, um zu überprüfen, ob der
// Zähler korrekt erhöht wird.
// Welche Methoden der Klasse Car könnten noch statisch gemacht werden und warum?
static class Runner
{
    public static void Run()
    {
        Console.WriteLine($"Cars created: {Car.GetCarCount()}");
        var car1 = new Car("Red", "Roadster", 220, 5.0, 2022);
        var car2 = new Car("Blue", "Sedan");
        var car3 = new Car(200, 6.5);
        Console.WriteLine($"Cars created: {Car.GetCarCount()}");

        var car4 = new Car();

        Console.WriteLine($"Cars created: {Car.GetCarCount()}");
        // Answer: none of the other instance methods are good static candidates - StartEngine, Drive,
        // GetFuelLevel, PrintTrip and LogStops all read or affect instance state (_fuelInTank, MaxSpeed,
        // etc.), so they need a specific Car instance to operate on. GetCarCount is static because it
        // only touches the shared _carCount field, not any single Car's data.
    }
}
