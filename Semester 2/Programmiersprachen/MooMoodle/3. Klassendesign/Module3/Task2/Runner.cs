namespace Module3.Task2;

// Aufgabe 2: Erstellen einer Klasse und eines Objekts
// Ändere die Eigenschaft Model der Klasse Car so, dass sie nach der Instanziierung nicht mehr änderbar ist.
// Kapsle das Feld MaxSpeed durch private Sichtbarkeit. Füge eine öffentliche Eigenschaft MaxSpeed hinzu,
// die den Zugriff auf das Feld ermöglicht, aber sicherstellt, dass der Wert 300 km/h nicht überschreiten kann.
// Teste das Verhalten, indem du verschiedene Werte für MaxSpeed setzt und überprüfst, ob die Begrenzung
// korrekt funktioniert.
static class Runner
{
    public static void Run()
    {
        // Model can now only be set through the constructor, so Car needs one starting here.
        var car = new Car("Red", "Roadster", 220);

        // var car = new Car()
        // {
        //     Color = "Red",
        //     Model = "Roadster",
        //     MaxSpeed = 220
        // };
        
        Console.WriteLine($"Initial MaxSpeed: {car.MaxSpeed}");

        car.MaxSpeed = 280;
        Console.WriteLine($"MaxSpeed after setting to 280: {car.MaxSpeed}");

        car.MaxSpeed = 350;
        Console.WriteLine($"MaxSpeed after setting to 350 (should be capped at 300): {car.MaxSpeed}");

        // car.Model = "Something else"; // does not compile - Model has no public setter
    }
}
