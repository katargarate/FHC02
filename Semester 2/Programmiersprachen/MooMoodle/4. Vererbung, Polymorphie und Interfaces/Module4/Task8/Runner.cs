namespace Module4.Task8;

// Aufgabe 8: Interfaces
// Erweitere die Klasse Vehicle um eine Methode CheckBrakes(), die eine Meldung ausgibt, dass die Bremsen
// überprüft wurden.
// Erstelle eine Schnittstelle IMaintenance mit der Methode ServiceCar().
// Implementiere IMaintenance in den Klassen Car und ElectricCar. Die Bremsen sollen überprüft werden und
// die spezifischen Methoden ReplaceFuelFilter() bzw. CheckBatteryHealth() aufgerufen werden.
// Implementiere eine Methode MaintainFleet in der Program-Klasse, die eine unbestimmte Anzahl an
// IMaintenance-Objekten entgegennimmt und ServiceCar() für jedes aufruft. Verwende den
// params-Modifizierer.
static class Runner
{
    // Plays the role of the "Program" class' MaintainFleet method for this task.
    private static void MaintainFleet(params IMaintenance[] vehicles)
    {
        foreach (var vehicle in vehicles)
        {
            vehicle.ServiceCar();
        }
    }

    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0);

        MaintainFleet(car, electricCar);
    }
}
