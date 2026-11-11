namespace Module4.Task4;

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
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0);

        car.Refuel(10);
        car.Refuel(5);

        electricCar.Refuel(20);
        electricCar.Refuel(15);
    }
}
