using System;

namespace NewApp;

// NEW FILE, PROJEKT AUSWAEHLEN, CLASS, CIRCLE 
public class Car
{
    public string color {get; set; }
    private int _maxSpeed {get; set; }
    public double FuelEfficiency {get; init;} // liters per 100km
    public string Model {get; init; } // kann nach der Initialisierung nicht mehr verändert werden, nur im Konstruktor oder bei der Deklaration gesetzt werden

    public double _fuelInTank = 50.0; // Initial fuel level in liters

    public const int MaxAllowedSpeed = 250; 

    public readonly int ManufacturedYear; // kann nur im Konstruktor gesetzt werden

    public static int CarCount = 0; 

    public Car(string model, double fuelEfficiency)
    {
        Model = model;
        FuelEfficiency = fuelEfficiency;
    }

    public Car (String color, int maxSpeed, string model, double fuelEfficiency, int manufacturedYear = 2024)
    {
        this.color = color;
        MaxSpeed = maxSpeed;
        Model = model;
        FuelEfficiency = fuelEfficiency;
        ManufacturedYear = manufacturedYear;
        CarCount++;
    }

    public Car(string color, string model) : this(color, 150, model, 5.0, 2026)
    {
    }

    public Car(int maxSpeed, double fuelEfficiency) : this("Unknown", maxSpeed, "Unknown", fuelEfficiency, 2026)
    {
    }

    public Car(): this("Unknown", 150, "Unknown", 5.0, 2026)
    {
    }


    public int MaxSpeed
    {
        get => _maxSpeed;
        set => _maxSpeed = value > MaxAllowedSpeed ? MaxAllowedSpeed : value;

    }

    public void StartEngine()
    {
        Console.WriteLine("Engine started.");
    }

    public void Drive(int distance)
    {
        Console.WriteLine($"Car has driven {distance} kilometers.");
    }

    public void Drive(int distance, int speed)
    {
        Console.WriteLine($"Car has driven {distance} kilometers at a speed of {speed} km/h.");
    }

    public double GetFuelLevel(out double maxDistance)
    {
        maxDistance = FuelEfficiency > 0 ? (_fuelInTank / FuelEfficiency) * 100 : 0; 
        return _fuelInTank;
    }

    public void PrintTrip(int distance, int speed = 100, string destination = "Unbekannt")
    {
        Console.WriteLine($"Trip to {destination}: {distance} km at {speed} km/h.");
    }


    public void LogStops(params string[] stops)
    {
        Console.WriteLine("Logging stops:");
        foreach (var stop in stops)
        {
            Console.WriteLine($"- {stop}");
        }
    }

    
}
