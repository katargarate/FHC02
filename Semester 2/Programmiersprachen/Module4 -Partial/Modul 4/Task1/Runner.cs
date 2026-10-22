namespace Module4.Task1;

// Aufgabe 1: Vererbung und Basisklasse
// Ändere die Klasse Car, indem du eine neue Basisklasse namens Vehicle einführst. Verschiebe gemeinsame
// Eigenschaften wie MaxSpeed, Model, Color und Methoden wie Drive in diese Basisklasse.
// Erstelle eine abgeleitete Klasse ElectricCar, die von Vehicle erbt und eine zusätzliche Eigenschaft
// BatteryCapacity hat.
// Füge der Basisklasse Vehicle einen Konstruktor hinzu, der MaxSpeed, Model und Color entgegennimmt, und
// rufe ihn aus den Konstruktoren von Car und ElectricCar über die base-Anweisung auf.
// Teste die Vererbung, indem du Instanzen von Car und ElectricCar erstellst, deren Eigenschaften setzt
// und die gemeinsame Methode Drive aufrufst.
static class Runner
{
    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        car.Color = "Blue";

        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0);

        car.Drive(150);
        electricCar.Drive(150);
    }
}
