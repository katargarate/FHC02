namespace Module5.Task5;

abstract class Vehicle
{
    public const int MaxAllowedSpeed = 250;

    private int _maxSpeed;

    public string Color = "";
    public string Model { get; }

    public int MaxSpeed
    {
        get => _maxSpeed;
        set
        {
            // Previously the value was silently capped at MaxAllowedSpeed - now it is rejected.
            if (value > MaxAllowedSpeed)
            {
                throw new SpeedLimitExceededException(value);
            }

            _maxSpeed = value;
        }
    }

    public Vehicle(string color, string model, int maxSpeed)
    {
        Color = color;
        Model = model;
        MaxSpeed = maxSpeed;
    }

    public virtual void Drive(int distance)
    {
        // First version with if + throw:
        // if (distance < 0)
        // {
        //     throw new ArgumentOutOfRangeException(nameof(distance), "The distance must not be negative.");
        // }

        // Short form - same exception type, but with a generated (English) message:
        // "distance ('-5') must be a non-negative value. (Parameter 'distance') Actual value was -5."
        ArgumentOutOfRangeException.ThrowIfNegative(distance);

        Console.WriteLine($"{Model} ({Color}) drove {distance} km.");
    }

    public abstract void Refuel(double amount);

    public static bool IsFaster(Vehicle v1, Vehicle v2)
    {
        return v1.MaxSpeed > v2.MaxSpeed;
    }

    public void CheckBrakes()
    {
        Console.WriteLine("Brakes checked.");
    }
}
