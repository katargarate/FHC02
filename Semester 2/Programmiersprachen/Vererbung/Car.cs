using System;

namespace NewApp;

// NEW FILE, PROJEKT AUSWAEHLEN, CLASS, CIRCLE 
public class Car : Vehicle
{
    
    public double FuelEfficiency {get; init;} // liters per 100km

    public double _fuelInTank = 50.0; // Initial fuel level in liters


    public static int CarCount = 0; 

    // -- Constructors

    public Car(string color, int maxSpeed, string model, double fuelEfficiency, int manufacturedYear) : base(model, manufacturedYear, color, maxSpeed)
    {
        FuelEfficiency = fuelEfficiency;
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


    // -- Methods  

    public override void Drive(int distance)
    {
       // add the Kraftstoffverbrauch as well
         double fuelConsumed = (FuelEfficiency / 100) * distance;
        base.Drive(distance);
        // round the fuel consumed to 2 decimal places
        fuelConsumed = Math.Round(fuelConsumed, 2);
        Console.WriteLine($"Fuel consumed: {fuelConsumed} liters.");

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


    public override void Refuel(double amount)
    {
        _fuelInTank += amount;
        Console.WriteLine($"Refueled {amount} liters. Current fuel level: {_fuelInTank} liters.");
    }

    
}
