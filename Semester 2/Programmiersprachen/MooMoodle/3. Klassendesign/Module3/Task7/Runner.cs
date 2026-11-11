namespace Module3.Task7;

// Aufgabe 7: Konstruktoren mit Verkettung
// Erstelle folgende Konstruktorversionen:
// - Eine die nur die Farbe und das Modell als Parameter akzeptiert. Der maxSpeed soll auf 150 km/h und
//   die fuelEfficiency auf 5.0 L/100km gesetzt werden.
// - Eine die nur die maxSpeed und fuelEfficiency als Parameter akzeptiert. Die Farbe soll auf "Unbekannt"
//   und das Modell auf "Standard" gesetzt werden.
// - Eine die keinen Parameter akzeptiert. Wähle die Standardwerte für alle Eigenschaften aus, die bei der
//   Instanziierung gesetzt werden müssen.
// Teste jede Konstruktorvariante, indem du Objekte der Klasse Car erstellst und deren Eigenschaften ausgibst.
static class Runner
{
    public static void Run()
    {
        var carByColorAndModel = new Car("Red", "Roadster");
        Console.WriteLine($"{carByColorAndModel.Color}, {carByColorAndModel.Model}, " +
                           $"{carByColorAndModel.MaxSpeed} km/h, {carByColorAndModel.FuelEfficiency} L/100km");

        var carBySpeedAndEfficiency = new Car(200, 6.5);
        Console.WriteLine($"{carBySpeedAndEfficiency.Color}, {carBySpeedAndEfficiency.Model}, " +
                           $"{carBySpeedAndEfficiency.MaxSpeed} km/h, {carBySpeedAndEfficiency.FuelEfficiency} L/100km");

        var defaultCar = new Car();
        Console.WriteLine($"{defaultCar.Color}, {defaultCar.Model}, " +
                           $"{defaultCar.MaxSpeed} km/h, {defaultCar.FuelEfficiency} L/100km");
    }
}
