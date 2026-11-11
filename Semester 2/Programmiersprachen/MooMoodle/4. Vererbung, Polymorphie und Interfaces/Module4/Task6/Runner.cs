namespace Module4.Task6;

// Aufgabe 6: Typuntersuchung und Typumwandlung
// Verwende Pattern-Matching mit dem is Operator um die MaintainVehicle Methode zu vereinfachen.
static class Runner
{
    private static void MaintainVehicle(Vehicle vehicle)
    {
        if (vehicle is Car car)
        {
            car.ReplaceFuelFilter();
        }
        else if (vehicle is ElectricCar electricCar)
        {
            electricCar.CheckBatteryHealth();
        }
    }

    public static void Run()
    {
        var car = new Car("Red", "Roadster", 220, 5.0, 2022);
        var electricCar = new ElectricCar("Silver", "Volt", 200, 75.0, 18.0);

        MaintainVehicle(car);
        MaintainVehicle(electricCar);
    }
}
