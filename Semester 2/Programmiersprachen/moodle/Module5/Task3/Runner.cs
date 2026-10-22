namespace Module5.Task3;

// Aufgabe 3: Benutzerdefinierte Ausnahmen
// Erstelle eine eigene Ausnahmeklasse SpeedLimitExceededException, die von Exception erbt.
// Sie soll eine Eigenschaft AttemptedSpeed haben, die im Konstruktor gesetzt wird. Die Fehlermeldung
// soll die versuchte Geschwindigkeit enthalten (Basisklassen-Konstruktor mit base(message) aufrufen).
// Ändere den Setter der Eigenschaft MaxSpeed in Vehicle so, dass statt der Begrenzung auf
// MaxAllowedSpeed eine SpeedLimitExceededException geworfen wird, wenn der Wert größer als
// MaxAllowedSpeed (250 km/h) ist.
// Teste die Lösung: Erstelle ein Fahrzeug mit einer Maximalgeschwindigkeit über 250 km/h und fange
// die Exception.
// Überlege: Was passiert mit dem Objekt, wenn die Exception bereits im Konstruktor geworfen wird?
static class Runner
{
    public static void Run()
    {
        Car? meinAuto = null;
        int countBefore = Car.GetCarCount();

        try
        {
            meinAuto = new Car("Red", "Rocket", 320, 6.0, 2024);
        }
        catch (SpeedLimitExceededException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
            Console.WriteLine($"Attempted speed: {ex.AttemptedSpeed} km/h");
        }

        Console.WriteLine($"car is null: {meinAuto is null}");
        Console.WriteLine($"Car count before: {countBefore}, after: {Car.GetCarCount()}");
        System.Console.WriteLine("----------------------");

        // Answer: The object never "arrives". `new` already allocated memory for it, but because the
        // constructor did not complete, no reference is returned - the assignment to `car` never
        // happens and the variable keeps its old value (null). The half-initialized object is not
        // reachable from anywhere and is cleaned up by the garbage collector.
        // Also note: Car's constructor body never runs (the exception is thrown in the Vehicle base
        // constructor via the MaxSpeed setter), so _carCount++ is skipped and the counter stays the same.

        // The setter also throws when the property is changed later on an existing object:
        var validCar = new Car("Blue", "Cruiser", 200, 5.0, 2023);
        try
        {
            validCar.MaxSpeed = 400;
        }
        catch (SpeedLimitExceededException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }

        Console.WriteLine($"MaxSpeed is still: {validCar.MaxSpeed} km/h");
    }
}
