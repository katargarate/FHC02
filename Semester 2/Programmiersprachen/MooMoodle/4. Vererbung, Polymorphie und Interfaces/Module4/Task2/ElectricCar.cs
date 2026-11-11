namespace Module4.Task2;

class ElectricCar : Vehicle
{
    public double BatteryCapacity { get; }
    public double EnergyConsumption { get; }

    // Designated constructor.
    public ElectricCar(string color, string model, int maxSpeed, double batteryCapacity, double energyConsumption)
        : base(color, model, maxSpeed)
    {
        BatteryCapacity = batteryCapacity;
        EnergyConsumption = energyConsumption;
    }

    //Chains into the designated constructor with a default battery capacity and energy consumption.
    public ElectricCar(string color, string model, int maxSpeed)
        : this(color, model, maxSpeed, 75.0, 18.0)
    {
    }

}
