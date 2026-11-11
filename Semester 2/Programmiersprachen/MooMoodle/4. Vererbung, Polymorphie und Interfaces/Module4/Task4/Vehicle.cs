namespace Module4.Task4;

abstract class Vehicle
{
    public const int MaxAllowedSpeed = 250;

    private int _maxSpeed;

    public string Color = "";
    public string Model { get; }

    public int MaxSpeed
    {
        get => _maxSpeed;
        set => _maxSpeed = value > MaxAllowedSpeed ? MaxAllowedSpeed : value;
    }

    public Vehicle(string color, string model, int maxSpeed)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed;
    }

    public virtual void Drive(int distance)
    {
        Console.WriteLine($"{Model} ({Color}) drove {distance} km.");
    }

    public abstract void Refuel(double amount);
}
