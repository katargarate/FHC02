namespace Module7.Task2;

// Aufgabe 2: Dictionary<TKey, TValue>
// Erstelle ein Dictionary, das Fahrzeugmodelle als Schlüssel und die entsprechenden Fahrzeugobjekte als
// Werte speichert.
// Füge Fahrzeuge zum Dictionary hinzu, wobei der Modellname als Schlüssel verwendet wird.
// Implementiere eine Methode FindVehicleByModel, die ein Fahrzeug anhand seines Modells aus dem
// Dictionary zurückgibt. Nutze die Methode TryGetValue, um sicherzustellen, dass der Schlüssel
// existiert, bevor auf das Fahrzeug zugegriffen wird.
// Implementiere eine Methode RemoveVehicleByModel die Fahrzeuge aus der Sammlung anhand des Modells
// entfernt.
static class Runner
{
    // Returns null if no vehicle with this model exists - hence the nullable return type Vehicle?.
    private static Vehicle? FindVehicleByModel(Dictionary<string, Vehicle> vehicles, string model)
    {
        // TryGetValue checks and reads in one step. Accessing vehicles[model] directly would throw a
        // KeyNotFoundException if the key does not exist.
        if (vehicles.TryGetValue(model, out Vehicle? vehicle))
        {
            return vehicle;
        }

        return null;
    }

    private static void RemoveVehicleByModel(Dictionary<string, Vehicle> vehicles, string model)
    {
        // Remove returns true if the key existed and was removed, false otherwise - no exception.
        if (vehicles.Remove(model))
        {
            Console.WriteLine($"{model} removed.");
        }
        else
        {
            Console.WriteLine($"{model} not found - nothing removed.");
        }
    }

    public static void Run()
    {
        var vehicles = new Dictionary<string, Vehicle>();

        var roadster = new Car("Red", "Roadster", 220, 5.0, 2022) { Type = VehicleType.Convertible };
        var volt = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0) { Type = VehicleType.Sedan };
        var ranger = new Car("Black", "Ranger", 190, 8.0, 2021) { Type = VehicleType.Suv };


        var vehicles2 = new Dictionary<string, Vehicle>()
        {
            {roadster.Model, roadster},
            {volt.Model, volt}
        };


        vehicles.Add(roadster.Model, roadster);
        vehicles.Add(volt.Model, volt);
        vehicles[ranger.Model] = ranger; // indexer: adds the key, or overwrites the value if it exists

        // Keys must be unique: Add with an existing key throws an ArgumentException.
        // TryAdd returns false instead.
        var secondRoadster = new Car("Green", "Roadster", 200, 5.5, 2023);
        if (!vehicles.TryAdd(secondRoadster.Model, secondRoadster))
        {
            Console.WriteLine($"A vehicle with model {secondRoadster.Model} already exists.");
        }

        foreach (var (model, vehicle) in vehicles)
        {
            Console.WriteLine($"{model}: {vehicle.Color}, Type {vehicle.Type}, max. {vehicle.MaxSpeed} km/h");
        }

        Console.WriteLine();
        Vehicle? found = FindVehicleByModel(vehicles, "Volt");
        Console.WriteLine(found is not null ? $"Found: {found.Model} ({found.Color})" : "Volt not found.");

        found = FindVehicleByModel(vehicles, "Beetle");
        Console.WriteLine(found is not null ? $"Found: {found.Model} ({found.Color})" : "Beetle not found.");

        Console.WriteLine();
        RemoveVehicleByModel(vehicles, "Roadster");
        RemoveVehicleByModel(vehicles, "Roadster");
        Console.WriteLine($"Remaining vehicles: {string.Join(", ", vehicles.Keys)}");
    }
}
