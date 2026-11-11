namespace Module3.Task5;

class Car
{
    private int _maxSpeed;
    private double _fuelInTank = 50.0;

    public string Color;
    public string Model { get; }

    public double FuelEfficiency { get; init; }

    public int MaxSpeed
    {
        get => _maxSpeed;
        set => _maxSpeed = value > 300 ? 300 : value;
    }

    public Car(string color, string model, int maxSpeed, double fuelEfficiency)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed;
        FuelEfficiency = fuelEfficiency;
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
        maxDistance = (FuelEfficiency > 0) ? _fuelInTank / FuelEfficiency * 100 : 0;
        return _fuelInTank;
    }
}
