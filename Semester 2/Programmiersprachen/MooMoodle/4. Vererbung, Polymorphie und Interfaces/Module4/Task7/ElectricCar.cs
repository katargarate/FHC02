namespace Module4.Task7;

class ElectricCar : Vehicle
{
    public double BatteryCapacity { get; }
    public double EnergyConsumption { get; }
    public double BatteryLevel { get; private set; }

    public ElectricCar(string color, string model, int maxSpeed, double batteryCapacity, double energyConsumption)
        : base(color, model, maxSpeed)
    {
        BatteryCapacity = batteryCapacity;
        EnergyConsumption = energyConsumption;
    }

    public ElectricCar(string color, string model, int maxSpeed)
        : this(color, model, maxSpeed, 75.0, 18.0)
    {
    }

    public override void Drive(int distance)
    {
        base.Drive(distance);
        double energyUsed = EnergyConsumption * distance / 100;
        Console.WriteLine($"Energy used: {energyUsed} kWh");
    }

    public override void Refuel(double amount)
    {
        BatteryLevel += amount;
        Console.WriteLine($"Battery level: {BatteryLevel} kWh");
    }

    public void CheckBatteryHealth()
    {
        Console.WriteLine("Battery health checked.");
    }
}
