namespace Module3.Task8;

// Aufgabe 8: Const und Readonly
// Füge der Klasse Car folgende Konstanten hinzu:
// - Eine const-Konstante int MaxAllowedSpeed mit dem Wert 250. Verwende sie in der MaxSpeed-Property,
//   sodass MaxSpeed diesen Wert nie überschreiten kann. Greife auf die Konstante über den Klassennamen
//   zu: Car.MaxAllowedSpeed.
// - Ein readonly-Feld int ManufacturedYear, das nur im Konstruktor gesetzt werden kann. Ergänze den
//   bestehenden Konstruktor um diesen Parameter.
// Teste beide: Versuche MaxSpeed über 250 zu setzen und prüfe, ob die Begrenzung greift. Versuche
// ManufacturedYear nach der Instanziierung zu ändern - was sagt der Compiler?
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);

        car.MaxSpeed = 260;
        Console.WriteLine($"MaxSpeed after setting to 260 (should be capped at {Car.MaxAllowedSpeed}): {car.MaxSpeed}");

        Console.WriteLine($"ManufacturedYear: {car.ManufacturedYear}");

        // car.ManufacturedYear = 2023; // does not compile - readonly fields can only be assigned in the constructor
    }
}
