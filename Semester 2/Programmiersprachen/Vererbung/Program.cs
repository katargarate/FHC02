namespace NewApp;

class Program
{
    static void Main(string[] args)
    {
        // Create instances of Vehicle, Car, and ElectricCar
    
        Car car = new("Blue", 200, "Sedan", 6.5, 2025);
        ElectricCar electricCar = new("Green", 160, "EV Model", 85.0, 2026);

        // Display information about the vehicles
        Console.WriteLine($"Car: {car.Model}, Year: {car.ManufacturedYear}, Color: {car.color}, Max Speed: {car.MaxSpeed} km/h, Fuel Efficiency: {car.FuelEfficiency} L/100km");
        Console.WriteLine($"Electric Car: {electricCar.Model}, Year: {electricCar.ManufacturedYear}, Color: {electricCar.color}, Max Speed: {electricCar.MaxSpeed} km/h, Battery Capacity: {electricCar.BatteryCapacity} kWh");

        // Start engines
        car.StartEngine();
        electricCar.StartEngine();

        // Drive the vehicles
        car.Drive(100);
        electricCar.Drive(150);

        // Log stops for the car
        car.LogStops("Gas Station", "Rest Area", "City Center");


        // call Drive for the car and electric car with different distances
        car.Drive(120);
        electricCar.Drive(200);

        // Refuel the car and electric car
        car.Refuel(20);
        electricCar.Refuel(30);
    }
}