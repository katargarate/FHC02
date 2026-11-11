public class ElectricCar : Vehicle
{
    public double BatteryCapacity { get; init; } // in kWh
    public double EnergyConsumption { get; init; } // kWh per 100km


    // -- Constructors
    public ElectricCar(string color, int maxSpeed, string model, double batteryCapacity, int manufacturedYear) 
        : base(model, manufacturedYear, color, maxSpeed)
    {
        BatteryCapacity = batteryCapacity;
        EnergyConsumption = 0.2; // Default energy consumption
    }

    public ElectricCar(string color, string model) : this(color, 150, model, 75.0, 2026)
    {
    }

    public ElectricCar(int maxSpeed, double batteryCapacity) : this("Unknown", maxSpeed, "Unknown", batteryCapacity, 2026)
    {
    }

    public ElectricCar() : this("Unknown", 150, "Unknown", 75.0, 2026)
    {
    }

    public override void Drive(int distance)
    {
        double energyConsumed = (EnergyConsumption / 100) * distance;
        base.Drive(distance);
        Console.WriteLine($"Energy consumed: {energyConsumed} kWh.");
    }

    public override void Refuel(double amount)
    {
        Console.WriteLine($"Charging the electric car with {amount} kWh.");
        Console.WriteLine($"Battery capacity: {BatteryCapacity} kWh.");
    }


}