namespace Module4.Task7;

// Aufgabe 7: Polymorphie
// Erstelle eine Liste vom Typ List<Vehicle> und füge sowohl Car- als auch ElectricCar-Objekte hinzu.
// Iteriere über die Liste und rufe auf jedem Objekt die Methode Drive() auf. Beobachte, welche
// Implementierung aufgerufen wird.
// Erkläre, warum das funktioniert: Was muss in Vehicle und in den abgeleiteten Klassen deklariert sein,
// damit der richtige Drive()-Aufruf zur Laufzeit aufgelöst wird?
// Bonus: Erweitere Vehicle um die statische Methode IsFaster(Vehicle v1, Vehicle v2), die true
// zurückgibt, wenn v1 schneller ist als v2. Rufe die Methode auf zwei Fahrzeugen aus der Liste auf.
static class Runner
{
    public static void Run()
    {
        var vehicles = new List<Vehicle>
        {
            new Car("Red", "Roadster", 220, 5.0, 2022),
            new ElectricCar("Silver", "Volt", 200, 75.0, 18.0),
            new Car("Black", "SUV", 280, 7, 2023),
            new ElectricCar("Blue", "BYD", 265)
        };


        foreach (var vehicle in vehicles)
        {
            vehicle.Drive(150);
            Console.WriteLine("---");
        }

        // Answer: Vehicle.Drive must be declared `virtual` and the derived classes' Drive must be
        // declared `override` with a matching signature. Because the list is typed as List<Vehicle>,
        // the compile-time type of each element is Vehicle, but the CLR looks up virtual/override
        // methods through the object's actual runtime type (its v-table), so the correct override runs.
        System.Console.WriteLine($"Is {vehicles[2].Model} faster than {vehicles[3].Model}?");

        Console.WriteLine(Vehicle.IsFaster(vehicles[2], vehicles[3]) ? "yes" : "no");

        //alternative to ternary operator
        if (Vehicle.IsFaster(vehicles[2], vehicles[3]))
        {
            System.Console.WriteLine("yes");
        }
        else
        {
            System.Console.WriteLine("no");
        }
    }
}
