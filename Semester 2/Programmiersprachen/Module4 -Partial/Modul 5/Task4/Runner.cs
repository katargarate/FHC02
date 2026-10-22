namespace Module5.Task4;

// Aufgabe 4: Ausnahmen weiterleiten, verpacken und filtern
// Schreibe in Program eine statische Methode CreateCar(int maxSpeed), die ein Car-Objekt erstellt und
// zurückgibt. Fange darin die SpeedLimitExceededException ab, gib „Fehler beim Erstellen protokolliert."
// aus und leite die Exception mit throw; weiter.
// Rufe CreateCar(350) in Main in einem try-catch auf und gib ex.StackTrace aus. Ersetze dann throw;
// durch throw e; und vergleiche: Welche Zeile fehlt jetzt im Stack Trace?
// Ersetze die Weiterleitung durch Verpacken in eine InvalidOperationException. Gib in Main sowohl die
// Meldung der äußeren Exception als auch die der InnerException aus.
// Erstelle jetzt ein Car direkt in Main und fange die SpeedLimitExceededException mit zwei catch-Blöcken:
// Der erste greift nur, wenn AttemptedSpeed > 400 ist (Ausgabe: „Das ist kein Auto, das ist ein
// Flugzeug!"), der zweite in allen anderen Fällen. Was passiert, wenn du die Reihenfolge der
// catch-Blöcke vertauschst?
static class Runner
{
    // The three CreateCar variants play the role of the "Program" class' CreateCar method for this task.
    // Each step of the task is kept as its own method so the outputs can be compared.

    // Step 1: forward the exception with `throw;`
    private static Car CreateCarRethrow(int maxSpeed)
    {
        try
        {
            return new Car("Red", "Rocket", maxSpeed, 6.0, 2024);
        }
        catch (SpeedLimitExceededException)
        {
            Console.WriteLine("Error during creation logged.");
            throw;
        }
    }

    // Step 2: forward the exception with `throw e;`
    private static Car CreateCarThrowE(int maxSpeed)
    {
        try
        {
            return new Car("Red", "Rocket", maxSpeed, 6.0, 2024);
        }
        catch (SpeedLimitExceededException e)
        {
            Console.WriteLine("Error during creation logged.");
#pragma warning disable CA2200 // Rethrow to preserve stack details - done on purpose for the comparison
            throw e;
#pragma warning restore CA2200
        }
    }

    // Step 3: wrap the exception in an InvalidOperationException
    private static Car CreateCarWrapped(int maxSpeed)
    {
        try
        {
            return new Car("Red", "Rocket", maxSpeed, 6.0, 2024);
        }
        catch (SpeedLimitExceededException e)
        {
            Console.WriteLine("Error during creation logged.");
            throw new InvalidOperationException("The car could not be created.", e);
        }
    }

    public static void Run()
    {
        Console.WriteLine("--- throw; ---");
        try
        {
            CreateCarRethrow(350);
        }
        catch (SpeedLimitExceededException ex)
        {
            Console.WriteLine(ex.StackTrace);
        }

        Console.WriteLine();
        Console.WriteLine("--- throw e; ---");
        try
        {
            CreateCarThrowE(350);
        }
        catch (SpeedLimitExceededException ex)
        {
            Console.WriteLine(ex.StackTrace);
        }

        // Answer: With `throw;` the stack trace starts where the exception was originally thrown
        // (Vehicle.set_MaxSpeed -> Vehicle..ctor -> Car..ctor -> CreateCarRethrow -> Run).
        // With `throw e;` the stack trace is reset to the line of `throw e;` - the lines from
        // Vehicle.set_MaxSpeed, the Vehicle constructor and the Car constructor are missing, so we no
        // longer see where the error really happened.

        Console.WriteLine();
        Console.WriteLine("--- wrapped ---");
        try
        {
            CreateCarWrapped(350);
        }
        catch (InvalidOperationException ex)
        {
            Console.WriteLine($"Outer exception: {ex.Message}");
            Console.WriteLine($"InnerException:   {ex.InnerException?.Message}");
        }

        Console.WriteLine();
        Console.WriteLine("--- exception filters ---");
        CreateWithFilter(350);
        CreateWithFilter(450);
    }

    private static void CreateWithFilter(int maxSpeed)
    {
        try
        {
            var car = new Car("Red", "Rocket", maxSpeed, 6.0, 2024);
        }
        catch (SpeedLimitExceededException ex) when (ex.AttemptedSpeed > 400)
        {
            Console.WriteLine("That's not a car, that's an airplane!");
        }
        catch (SpeedLimitExceededException ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }

        // Answer: If the order is swapped, the code no longer compiles:
        // error CS0160: A previous catch clause already catches all exceptions of this or of a super
        // type ('SpeedLimitExceededException').
        // catch blocks are checked from top to bottom - the unfiltered block would catch every
        // SpeedLimitExceededException, so the filtered block below it could never be reached.
    }
}
