namespace Module5.Task6;

static class Runner
{

    public static void Run()
    {
        // erstelle eine Dictionary, das Fahrzeugmodelle als Schlüssel und die entsprechenden Fahrzeigsobjekte als Werte speichert
        // Füge Fahrzeuge hinzu, wobei der Modellname als Schlüssel verwendet wird
        var vehicles = new Dictionary<string, Vehicle>
        {
            { "Car", new Car("blue", "Toyota Camry", 100, 200, 10) },
            { "ElectricCar", new ElectricCar("red", "Tesla Model S", 100, 500, 10) }
        };

        // rufe die Methode FindVehicleByModel auf, um ein Fahrzeug anhand seines Modells zu finden
        var foundVehicle = FindVehicleByModel("Car", vehicles);
        if (foundVehicle != null)
        {
            Console.WriteLine($"Found vehicle: {foundVehicle.GetType().Name}");
        }   

        // rufe die Methode RemoveVehicleByModel auf, um ein Fahrzeug anhand seines Modells zu entfernen
        RemoveVehicleByModel<Car>("Car", vehicles);
        // versuche erneut, das entfernte Fahrzeug zu finden
        var removedVehicle = FindVehicleByModel("Car", vehicles);
        if (removedVehicle == null)
        {
            Console.WriteLine("Vehicle has been removed and is no longer in the dictionary.");
        }
        else 
        {
            Console.WriteLine($"Found vehicle: {removedVehicle.GetType().Name}");
        }


    }

    // implementire eine Methode FindVehicleByModel, die ein Fahrzeug anhand seines Modells aus der Dictionary zurückgibt
    // Nutze die Methode TryGetValue, um sicherzustellen, dass der Schlüssel existiert, bevor auf das Fahrzeug gegriffen wird
    public static Vehicle? FindVehicleByModel(string model, Dictionary<string, Vehicle> vehicles)
    {
        if (vehicles.TryGetValue(model, out Vehicle vehicle))
        {
            return vehicle;
        }
        else
        {
            Console.WriteLine($"Vehicle with model '{model}' not found.");
            return null;
        }
    }

    // implementiere eine Methode RemoveVehicleByModel, die ein Fahrzeug anhand seines Modells aus der Dictionary entfernt
    public static void RemoveVehicleByModel<T> (string model, Dictionary<string, Vehicle> vehicles)
    {
        if (vehicles.Remove(model))
        {
            Console.WriteLine($"Vehicle with model '{model}' removed.");
        }
        else
        {
            Console.WriteLine($"Vehicle with model '{model}' not found.");
        }
    }
}
