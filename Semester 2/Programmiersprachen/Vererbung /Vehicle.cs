public abstract class Vehicle 
{
    public string Model { get; set; }
    public int ManufacturedYear { get; set; }
    public string color;
    private int _maxSpeed;
    private const int MaxAllowedSpeed = 300;

    // -- Constructors
    public Vehicle(string model, int manufacturedYear, string color, int maxSpeed)
    {
        Model = model;
        ManufacturedYear = manufacturedYear;
        this.color = color;
        MaxSpeed = maxSpeed;
    }

    public Vehicle(string model, string color, int maxSpeed) : this(model, 2024, color, maxSpeed)
    {
    }

    public Vehicle(string model, int manufacturedYear) : this(model, manufacturedYear, "Unknown", 150)
    {
    }

    public Vehicle(string model) : this(model, 2024, "Unknown", 150)
    {
    }


    // -- Properties

    public int MaxSpeed
    {
        get => _maxSpeed;
        set => _maxSpeed = value > MaxAllowedSpeed ? MaxAllowedSpeed : value;

    }

    // -- Methods
    public void StartEngine()
    {
        Console.WriteLine("Engine started.");
    }


    public virtual void Drive(int distance)
    {
        Console.WriteLine($"Vehicle (Model: {Model} {color}) has driven {distance} kilometers.");
    }

    public void LogStops(params string[] stops)
    {
        Console.WriteLine("Logging stops:");
        foreach (var stop in stops)
        {
            Console.WriteLine($"- {stop}");
        }
    }

    public abstract void Refuel(double amount);
}