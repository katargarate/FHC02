namespace Module5.Task2;

// Aufgabe 2: Exceptions werfen
// Ändere die Methode Drive der Klasse Vehicle so, dass sie eine ArgumentOutOfRangeException wirft, wenn
// die übergebene Distanz negativ ist. Die Fehlermeldung soll angeben, dass die Distanz nicht negativ
// sein darf.
// Stelle sicher, dass die überschriebenen Drive-Methoden in Car und ElectricCar zuerst
// base.Drive(distance) aufrufen.
// Fange die Exception beim Aufruf von Drive in Main und gib die Fehlermeldung (Message) auf der
// Konsole aus.
// Ersetze danach dein if + throw durch die Kurzform ArgumentOutOfRangeException.ThrowIfNegative(distance);
// und vergleiche die Fehlermeldungen.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0);

        try
        {
            car.Drive(100);
            // Car.Drive calls base.Drive first, so the exception is thrown before the fuel
            // consumption is calculated - "Fuel used" is never printed for the negative distance.
            car.Drive(-5);
        }
        catch (ArgumentOutOfRangeException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
        System.Console.WriteLine("------");
        try
        {
            electricCar.Drive(-20);
        }
        catch (ArgumentOutOfRangeException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }

        // Comparison of the messages:
        // if + throw:      "The distance must not be negative. (Parameter 'distance')"
        // ThrowIfNegative: "distance ('-5') must be a non-negative value. (Parameter 'distance')
        //                   Actual value was -5."
        // The short form generates the message itself: it contains the parameter name (via
        // CallerArgumentExpression) and the actual value, but it is always in English.
    }
}
