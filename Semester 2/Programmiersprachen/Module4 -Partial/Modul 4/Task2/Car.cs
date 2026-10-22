namespace Module4.Task2;

class Car : Vehicle
{
    private static int _carCount;
    private double _fuelInTank = 50.0;

    public double FuelEfficiency { get; }
    public readonly int ManufacturedYear;

    // Designated constructor - the other three chain into this one via `: this(...)`.
    public Car(string color, string model, int maxSpeed, double fuelEfficiency, int manufacturedYear)
        : base(color, model, maxSpeed)
    {
        FuelEfficiency = fuelEfficiency;
        ManufacturedYear = manufacturedYear;
        _carCount++;
    }

    public Car(string color, string model) : this(color, model, 150, 5.0, DateTime.Now.Year)
    {
    }

    public Car(int maxSpeed, double fuelEfficiency)
        : this("Unbekannt", "Standard", maxSpeed, fuelEfficiency, DateTime.Now.Year)
    {
    }

    public Car() : this("Unbekannt", "Standard", 150, 5.0, DateTime.Now.Year)
    {
    }

    public static int GetCarCount()
    {
        return _carCount;
    }

    public void StartEngine()
    {
        Console.WriteLine("Engine started.");
    }

    public void Drive(int distance, int speed)
    {
        Console.WriteLine($"Drove {distance} km at {speed} km/h.");
    }

    public double GetFuelLevel()
    {
        return _fuelInTank;
    }

    public double GetFuelLevel(out double maxDistance)
    {
        maxDistance = FuelEfficiency > 0 ? _fuelInTank / FuelEfficiency * 100 : 0;
        return _fuelInTank;
    }

    public void PrintTrip(int distance, int speed = 100, string destination = "Unbekannt")
    {
        Console.WriteLine($"Fahrt nach {destination}: {distance} km bei {speed} km/h");
    }

    public void LogStops(params string[] stops)
    {
        foreach (var stop in stops)
        {
            Console.WriteLine(stop);
        }
    }
}
