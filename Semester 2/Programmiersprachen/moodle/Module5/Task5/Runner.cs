namespace Module5.Task5;

static class Runner
{

    public static void Run()
    {
        List<Vehicle> vehicles = new List<Vehicle>
        {
            new Car("Red", "Toyota", 180, 12.0, 2026),
            new ElectricCar("Blue", "Tesla", 200, 100.0, 20.0),
            new Car("Green", "Honda", 160, 10.0, 2025),
            new ElectricCar("Yellow", "Nissan", 180, 80.0, 18.0)
        };

        PrintFleetDetails(vehicles);
        DeleteVehiclesOfType<ElectricCar>(vehicles);
        Console.WriteLine("After deleting electric cars:");
        PrintFleetDetails(vehicles);
    }

    static void PrintFleetDetails(List<Vehicle> vehicles)
    {
        // Print details of each vehicle in the fleet, incl model, vehicle type, and max speed.
        foreach (var vehicle in vehicles)
        {
            Console.WriteLine($"Color: {vehicle.Color}, Model: {vehicle.Model}, Vehicle Type: {vehicle.GetType().Name}, Max Speed: {vehicle.MaxSpeed} km/h");
        }
    }

    static void DeleteVehiclesOfType<T>(List<Vehicle> vehicles) where T : Vehicle
    {
        // hinten anfangen, damit die Indizes beim Löschen nicht durcheinander geraten
        for (int i = vehicles.Count - 1; i >= 0; i--)
        {
            if (vehicles[i] is T)
            {
                vehicles.RemoveAt(i);
            }
        }
    }

}
