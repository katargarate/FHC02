namespace Module5.Task1;

// Aufgabe 1: Fehlerbehandlung
// Erstelle eine Instanz der Klasse Car und frage den Benutzer, welche Distanz er fahren möchte
// (in Kilometern).
// Lies die Eingabe mit int.Parse ein und fange eine FormatException ab, falls keine gültige Zahl
// eingegeben wurde. Gib im catch-Block eine Fehlermeldung aus.
// Fange in einem zweiten catch-Block eine OverflowException ab (z. B. bei der Eingabe 99999999999).
// Gib in einem finally-Block „Eingabe verarbeitet." aus.
// Ersetze anschließend den try-catch-Block durch int.TryParse und wiederhole die Abfrage so lange,
// bis eine gültige Zahl eingegeben wurde. Rufe dann die Methode Drive auf.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);

        RunWithTryCatch(car);
        RunWithTryParse(car);
    }

    // Step 1: int.Parse with try-catch-finally.
    private static void RunWithTryCatch(Car car)
    {
        Console.Write("How many kilometers do you want to drive? ");
        try
        {
            int distance = int.Parse(Console.ReadLine() ?? "");
            car.Drive(distance);

        }
        catch (FormatException)
        {
            Console.WriteLine("Error: Please enter a valid whole number.");
        }
        catch (OverflowException)
        {
            Console.WriteLine($"Error: The number is too large or too small (allowed: {int.MinValue} to {int.MaxValue}).");
        }
        finally
        {
            // Runs no matter whether the try block succeeded or a catch block was executed.
            Console.WriteLine("Input processed.");
        }
    }

    // Step 2: the try-catch replaced by int.TryParse - no exception is thrown for invalid input,
    // so we can simply loop until the user enters a valid number.
    private static void RunWithTryParse(Car car)
    {
        int distance;
        Console.Write("How many kilometers do you want to drive? ");
        while (!int.TryParse(Console.ReadLine(), out distance))
        {
            Console.Write("Invalid input. Please enter a whole number: ");
        }

        car.Drive(distance);
    }
}
