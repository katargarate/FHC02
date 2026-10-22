namespace Module4.Task6;

// Aufgabe 4: Abstrakte Klassen und Methoden
// Wandle die Klasse Vehicle in eine abstrakte Klasse um.
// Füge der Klasse Vehicle eine abstrakte Methode Refuel(double amount) hinzu, die in abgeleiteten
// Klassen implementiert werden muss.
// Implementiere die Methode Refuel in der Klasse Car, sodass sie den Kraftstoffstand um den gegebenen
// Betrag erhöht. Der aktuelle Kraftstoffstand soll dann auf der Konsole ausgegeben werden.
// Erweitere die Klasse ElectricCar um Eigenschaft BatteryLevel. Implementiere die Methode Refuel in der
// Klasse ElectricCar, sodass sie den Ladezustand der Batterie um den gegebenen Betrag (kWh) erhöht. Gib
// den aktuellen Ladezustand auf der Konsole aus.
// Teste das Verhalten, indem du Instanzen von Car und ElectricCar erstellst und die Methode Refuel
// mehrmals aufrufst.
static class Runner
{
    public static void Run()
    {
        Console.WriteLine("\nCar:");
        MaintainVehicle(new Car("Red", "Roadster", 220, 5.0, 2022));
        Console.WriteLine("\nElectric Car:");
        MaintainVehicle(new ElectricCar("Silver", "Volt", 200, 75.0, 32.0));

        Console.WriteLine("\n\nCar (Alt):");
        MaintainVehicleAlt(new Car("Blue", "Coupe", 180, 6.0, 2021));
        Console.WriteLine("\nElectric Car (Alt):");
        MaintainVehicleAlt(new ElectricCar("Green", "Leaf", 150, 40.0, 15.0));
    }


    public static void MaintainVehicle(Vehicle vehicle)
    {
        if (vehicle is Car car)
        {
            car.ReplaceFuelFilter();
        }
        else if (vehicle is ElectricCar electricCar)
        {
            electricCar.CheckBatteryLevel();
        }
        else
        {
            Console.WriteLine("Unknown vehicle type.");
        }
    }

    public static void MaintainVehicleAlt(Vehicle vehicle)
    {
        Car? c = vehicle as Car;

        if (c != null)
        {
            c.ReplaceFuelFilter();
        }
        else
        {
            ElectricCar? e = vehicle as ElectricCar;
            if (e != null)
            {
                e.CheckBatteryLevel();
            }
            else
            {
                Console.WriteLine("Unknown vehicle type.");
            }
        }
    }

    public static void MaintainVehicleAlt2(Vehicle vehicle)
    {
        if (vehicle is Car c && c.Color == "Red"){
            c.ReplaceFuelFilter();
        } else if (vehicle is ElectricCar e && e.Model == "Volt")
        {
            e.CheckBatteryLevel();
        } else
        {
            Console.WriteLine("Unknown vehicle type.");
        }
           
    }
}
