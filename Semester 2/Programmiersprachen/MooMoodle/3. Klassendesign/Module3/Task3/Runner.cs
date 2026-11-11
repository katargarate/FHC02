namespace Module3.Task3;

// Aufgabe 3: Methoden zur Klasse Car hinzufügen
// Erweitere die Klasse Car um ein privates Feld: double _fuelInTank. Füge dann folgende Methoden hinzu:
// - StartEngine: gibt eine Meldung auf der Konsole aus, dass der Motor gestartet wurde.
// - Drive: nimmt eine Distanz (in Kilometern) als Parameter und gibt eine Meldung auf der Konsole aus,
//   dass das Auto die angegebene Distanz gefahren ist.
// - GetFuelLevel: gibt einen double zurück, der den Kraftstoffstand des Autos (_fuelInTank) zurückgibt.
// Teste die Methoden, indem du ein neues Car-Objekt erstellst, den Motor startest, eine Distanz fährst
// und den Kraftstoffstand ausgibst.
static class Runner
{
    public static void Run()
    {
        // _fuelInTank has no dedicated parameter yet, so it starts at a fixed default (see field initializer).
        var car = new Car("Red", "Roadster", 220);

        car.StartEngine();
        car.Drive(150);
        Console.WriteLine($"Fuel level: {car.GetFuelLevel()}");
    }
}
