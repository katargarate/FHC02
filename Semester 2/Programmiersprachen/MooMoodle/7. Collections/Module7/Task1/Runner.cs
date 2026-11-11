namespace Module7.Task1;

// Aufgabe 1: List<T>
// Erstelle eine Collection List<Vehicle>, um eine Flotte von verschiedenen Fahrzeugen zu verwalten.
// Füge verschiedene Fahrzeuge der Typen Car und ElectricCar zur Liste hinzu.
// Implementiere eine Methode PrintFleetDetails(), die durch die Liste iteriert und Details zu jedem
// Fahrzeug ausgibt, wie Modell, Fahrzeugtyp (VehicleType) und Maximalgeschwindigkeit.
// Implementiere eine Methode, die alle Fahrzeuge einer bestimmten Klasse (Car oder ElectricCar) aus der
// Liste entfernt.
static class Runner
{
    private static void PrintFleetDetails(List<Vehicle> fleet)
    {
        Console.WriteLine($"Fleet with {fleet.Count} vehicles:");
        foreach (var vehicle in fleet)
        {
            Console.WriteLine($"- {vehicle.Model} ({vehicle.GetType().Name}): Type {vehicle.Type}, " +
                              $"max. {vehicle.MaxSpeed} km/h");
        }
    }

    // Generic method: T is the class to remove, e.g. RemoveVehiclesOfClass<Car>(fleet).
    // `where T : Vehicle` restricts T to Vehicle and its subclasses.
    private static void RemoveVehiclesOfClass<T>(List<Vehicle> fleet) where T : Vehicle
    {
        // Iterate backwards: removing an element shifts all following elements one index to the left.
        // Going forwards would skip the element right after a removed one.
        // (Removing inside a foreach is not allowed at all - it throws an InvalidOperationException.)
        for (int i = fleet.Count - 1; i >= 0; i--)
        {
            if (fleet[i] is T)
            {
                fleet.RemoveAt(i);
            }
        }

        // Short form with a lambda expression - does the same:
        // fleet.RemoveAll(vehicle => vehicle is T);
    }

    public static void Run()
    {
        var fleet = new List<Vehicle>
        {
            new Car("Red", "Roadster", 220, 5.0, 2022) { Type = VehicleType.Convertible },
            new Car("Blue", "Family", 180, 6.5, 2020) { Type = VehicleType.Van },
            new ElectricCar("Silver", "Volt", 200, 75.0, 18.0) { Type = VehicleType.Sedan }
        };

        // Add() appends a single element to the end of the list
        fleet.Add(new ElectricCar("White", "Cyber", 210) { Type = VehicleType.Truck });
        fleet.Add(new Car("Black", "Ranger", 190, 8.0, 2021) { Type = VehicleType.Suv });

        PrintFleetDetails(fleet);

        Console.WriteLine();
        Console.WriteLine("Removing all cars...");
        RemoveVehiclesOfClass<Car>(fleet);
        PrintFleetDetails(fleet);
    }
}
