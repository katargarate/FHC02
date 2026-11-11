namespace Module3.Task3;

class Car
{
    private int _maxSpeed;
    private double _fuelInTank = 50.0;

    public string Color;
    public string Model { get; }

    public int MaxSpeed
    {
        get => _maxSpeed;
        set => _maxSpeed = value > 300 ? 300 : value;
    }

    public Car(string color, string model, int maxSpeed)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed;
    }

    public void StartEngine()
    {
        Console.WriteLine("Engine started.");
    }

    public void Drive(int distance)
    {
        Console.WriteLine($"Drove {distance} km.");
    }

    public double GetFuelLevel() //=> _fuelInTank;
    {
        return _fuelInTank;
    }
}
