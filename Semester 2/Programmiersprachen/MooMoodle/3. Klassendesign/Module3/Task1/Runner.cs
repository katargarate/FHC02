namespace Module3.Task1;

// Aufgabe 1: Grundlegende Klassenerstellung
// Erstelle eine Klasse Car mit drei öffentlichen Feldern:
// - string Color
// - int MaxSpeed
// - string Model
// Instanziiere ein neues Car-Objekt und weise dessen Eigenschaften Werte zu.
// Gebe anschließend die Werte der Felder mit Console.WriteLine() aus.
static class Runner
{
    public static void Run()
    {
        Car car = new Car();
        car.Color = "Red";
        car.MaxSpeed = 220;
        car.Model = "Roadster";

        Console.WriteLine($"Color: {car.Color}");
        Console.WriteLine($"MaxSpeed: {car.MaxSpeed}");
        Console.WriteLine($"Model: {car.Model}");
    }
}
