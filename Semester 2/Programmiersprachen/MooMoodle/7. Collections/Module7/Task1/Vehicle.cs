namespace Module7.Task1;

abstract class Vehicle
{
    public const int MaxAllowedSpeed = 250;

    private int _maxSpeed;

    public string Color = "";
    public string Model { get; }
    public VehicleType Type { get; set; }

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

    public void DescribeVehicle()
    {
        string description = Type switch
        {
            VehicleType.Sedan => "a classic sedan with a separate trunk",
            VehicleType.Suv => "an SUV with a raised driving position",
            VehicleType.Truck => "a truck built for transporting goods",
            VehicleType.Hatchback => "a compact hatchback with a rear door",
            VehicleType.Convertible => "a convertible with a retractable roof",
            VehicleType.Van => "a van with lots of space for passengers or cargo",
            _ => "a vehicle of unknown type"
        };

        Console.WriteLine($"{Model} ({Color}) is {description}.");
    }
}
