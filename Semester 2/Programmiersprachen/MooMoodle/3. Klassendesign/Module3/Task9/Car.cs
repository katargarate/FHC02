namespace Module3.Task9;

class Car 
{
    public const int MaxAllowedSpeed = 250;

    private static int _carCount;

    private int _maxSpeed;
    private double _fuelInTank = 50.0;

    public string Color;
    public string Model { get; }
    public double FuelEfficiency { get; }
    public readonly int ManufacturedYear;

    public int MaxSpeed
    {
        get => _maxSpeed;
        set => _maxSpeed = value > MaxAllowedSpeed ? MaxAllowedSpeed : value;
    }

    // Designated constructor - the other three chain into this one via `: this(...)`.
    // _carCount is incremented only here: every other constructor delegates into this one before its
    // own (empty) body runs, so counting here still counts each Car exactly once, no matter which
    // overload was used to create it.
    public Car(string color, string model, int maxSpeed, double fuelEfficiency, int manufacturedYear)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed;
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

    public void Drive(int distance)
    {
        Console.WriteLine($"Drove {distance} km.");
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
