namespace Module4.Task7;

// Aufgabe 4: Abstrakte Klassen und Methoden
// Wandle die Klasse Vehicle in eine abstrakte Klasse um.
// Füge der Klasse Vehicle eine abstrakte Methode Refuel(double amount) hinzu, die in abgeleiteten
// Klassen implementiert werden muss.
// Implementiere die Methode Refuel in der Klasse Car, sodass sie den Kraftstoffstand um den gegebenen
// Betrag erhöht. Der aktuelle Kraftstoffstand soll dann auf der Konsole ausgegeben werden.
// Erweitere die Klasse ElectricCar um Eigenschaft BatteryLevel. Implementiere die Methode Refuel in der
// Klasse ElectricCar, sodass sie den Ladezustand der Batterie um den gegebenen Betrag (kWh) erhöht. Gib
// den aktuellen Ladezustand auf der Konsole aus.
// Teste das Verhalten, indem du Instanzen von Car und ElectricCar erstellst und die Methode Refuel
// mehrmals aufrufst.
static class Runner
{
    public static void Run()
    {
        // Frage: Was muss in Vehicle und in den abgeleiteten Klassen deklariert sein, damit der richtige Drive() 
        // Aufruf zur Laufzeit ausgelöst wird?

        // Antwort: Die Methode Drive() muss in der Basisklasse Vehicle als virtual deklariert werden, 
        // und in den abgeleiteten Klassen Car und ElectricCar muss sie mit override überschrieben werden. 
        // Dadurch wird zur Laufzeit die richtige Implementierung der Drive() Methode basierend auf dem tatsächlichen 
        // Typ des Objekts aufgerufen.

        var vehicles = new List<Vehicle>
        {
            new Car("Red", "Roadster", 220, 5.0, 2022),
            new ElectricCar("Silver", "Volt", 200, 75.0, 32.0),
            new Car("Blue", "Coupe", 180, 6.0, 2021),
            new ElectricCar("Green", "Leaf", 150, 40.0, 15.0)
        };

        foreach (var vehicle in vehicles)
        {
            vehicle.Drive(100);
        }

        if (Vehicle.IsFaster(vehicles[0], vehicles[1]))
        {
            Console.WriteLine("{0} is faster than {1}.", vehicles[0].Model, vehicles[1].Model);
        }
        else
        {
            Console.WriteLine("{0} is not faster than {1}.", vehicles[0].Model, vehicles[1].Model);
        }

    }


}
