namespace Module3.Task7;

class Car
{
    private int _maxSpeed;
    private double _fuelInTank = 50.0;

    public string Color;
    public string Model { get; }
    public double FuelEfficiency { get; }

    public int MaxSpeed
    {
        get => _maxSpeed;
        set => _maxSpeed = value > 300 ? 300 : value;
    }

    // Designated constructor - the other three chain into this one and just supply defaults.
    public Car(string color, string model, int maxSpeed, double fuelEfficiency)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed;
        FuelEfficiency = fuelEfficiency;
    }

    public Car(string color, string model) : this(color, model, 150, 5.0)
    {
    }

    public Car(int maxSpeed, double fuelEfficiency) : this("Unbekannt", "Standard", maxSpeed, fuelEfficiency)
    {
    }

    public Car() : this("Unbekannt", "Standard", 150, 5.0)
    {
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
