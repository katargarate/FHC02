namespace Module4.Task3;

// Aufgabe 3: Geerbte Methoden
// Ändere die Methode Drive in der Klasse Vehicle so, dass sie die Information über das Modell und Farbe
// ausgibt.
// Überschreibe die Methode Drive in Car, so dass sie zusätzlich die Information über den
// Kraftstoffverbrauch ausgibt (FuelEfficiency * distance / 100).
// Überschreibe die Methode Drive in ElectricCar, so dass sie zusätzlich die Information über den
// Energieverbrauch ausgibt (EnergyConsumption * distance / 100).
// Teste dies, indem du Instanzen beider Klassen erstellst und die Methode Drive auf beiden aufrufst.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0);

        car.Drive(150);
        electricCar.Drive(150);
    }
}
