namespace Module4.Task1;

class ElectricCar : Vehicle
{
    public double BatteryCapacity { get; }

    public ElectricCar(string color, string model, int maxSpeed, double batteryCapacity)
        : base(color, model, maxSpeed)
    {
        BatteryCapacity = batteryCapacity;
    }
}
